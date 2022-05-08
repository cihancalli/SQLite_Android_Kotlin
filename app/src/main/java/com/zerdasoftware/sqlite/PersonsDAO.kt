package com.zerdasoftware.sqlite

import android.content.ContentValues

class PersonsDAO {

    fun PersonAdd(dbHelper:DBHelper,persons: Persons){
        val db = dbHelper.writableDatabase
        val values = ContentValues()
        values.put("person_name",persons.person_name)
        values.put("person_number",persons.person_number)
        values.put("person_age",persons.person_age)
        values.put("person_height",persons.person_height)

        db.insertOrThrow("persons",null,values)
        db.close()
    }
}