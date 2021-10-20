package com.example.vittamvino.db.migrations

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_2_3 = object : Migration(2, 3) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("DROP TABLE wine")
        database.execSQL("CREATE TABLE wine(\n" +
                "\tid INTEGER,\n" +
                "\tname TEXT,\n" +
                "\trating REAL,\n" +
                "\tproducerId INTEGER,\n" +
                "\ttypeId INTEGER,\n" +
                "\tflavourId INTEGER,\n" +
                "\tPRIMARY KEY (id)\n" +
                ")")
    }

}