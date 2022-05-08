package com.zerdasoftware.sqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context,"directory",null,1){

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE persons (person_id INTEGER PRIMARY KEY AUTOINCREMENT " +
                ",person_name TEXT,person_number TEXT,person_age INTEGER,person_height DOUBLE );")
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS persons")
        onCreate(db)
    }
}