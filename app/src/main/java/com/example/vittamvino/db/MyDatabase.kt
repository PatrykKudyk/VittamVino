package com.example.vittamvino.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vittamvino.db.wine.Wine
import com.example.vittamvino.db.wine.WineDao


@Database(
    entities = [Wine::class],
    version = 1
)
abstract class MyDatabase: RoomDatabase() {

    abstract fun winesDao(): WineDao

    companion object {
        private var databaseInstance: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase? {
            if (databaseInstance == null) {
                synchronized(MyDatabase::class.java) {
                    if (databaseInstance == null) {
                        databaseInstance = Room.databaseBuilder<MyDatabase>(
                            context.applicationContext,
                            MyDatabase::class.java, "my_database"
                        ).build()
                    }
                }
            }
            return databaseInstance
        }
    }
}