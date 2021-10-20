package com.example.vittamvino.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vittamvino.db.flavour.Flavour
import com.example.vittamvino.db.flavour.FlavourDao
import com.example.vittamvino.db.migrations.MIGRATION_2_3
import com.example.vittamvino.db.producer.Producer
import com.example.vittamvino.db.producer.ProducerDao
import com.example.vittamvino.db.type.Type
import com.example.vittamvino.db.type.TypeDao
import com.example.vittamvino.db.wine.Wine
import com.example.vittamvino.db.wine.WineDao


@Database(
    entities = [Wine::class, Flavour::class, Producer::class, Type::class],
    version = 3
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun wineDao(): WineDao
    abstract fun flavourDao(): FlavourDao
    abstract fun producerDao(): ProducerDao
    abstract fun typeDao(): TypeDao


    companion object {
        private var databaseInstance: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase? {
            if (databaseInstance == null) {
                synchronized(MyDatabase::class.java) {
                    if (databaseInstance == null) {
                        databaseInstance = Room.databaseBuilder(
                            context.applicationContext,
                            MyDatabase::class.java,
                            "my_database"
                        )
                            .addMigrations(MIGRATION_2_3)
                            .build()
                    }
                }
            }
            return databaseInstance
        }
    }
}