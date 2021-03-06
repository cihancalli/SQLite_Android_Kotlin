package com.zerdasoftware.sqlite

import android.annotation.SuppressLint
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

    @SuppressLint("Range")
    fun AllPerson(dbHelper:DBHelper) : ArrayList<Persons>{

        val personsArrayList = ArrayList<Persons>()
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM persons ",null)

        while (cursor.moveToNext()){
            val person = Persons(cursor.getInt(cursor.getColumnIndex("person_id")),
                cursor.getString(cursor.getColumnIndex("person_name")),
                cursor.getString(cursor.getColumnIndex("person_number")),
                cursor.getInt(cursor.getColumnIndex("person_age")),
                cursor.getDouble(cursor.getColumnIndex("person_height")))
            personsArrayList.add(person)
        }
        return personsArrayList
    }

    fun PersonUpdate(dbHelper:DBHelper,persons: Persons){
        val db = dbHelper.writableDatabase
        val values = ContentValues()
        values.put("person_name",persons.person_name)
        values.put("person_number",persons.person_number)
        values.put("person_age",persons.person_age)
        values.put("person_height",persons.person_height)

        db.update("persons",values,"person_id=?", arrayOf(persons.person_id.toString()))
        //db.update("persons",values,"person_id=? and person_name=? ", arrayOf(persons.person_id.toString(),persons.person_name))
        db.close()
    }

    fun PersonDelete(dbHelper:DBHelper,person_id:Int){
        val db = dbHelper.writableDatabase
        db.delete("persons","person_id=?",arrayOf(person_id.toString()))
        db.close()
    }

    @SuppressLint("Range")
    fun PersonSerach(dbHelper:DBHelper,keyWord:String) : ArrayList<Persons>{

        val personsArrayList = ArrayList<Persons>()
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM persons WHERE person_name like '%$keyWord%'",null)

        while (cursor.moveToNext()){
            val person = Persons(cursor.getInt(cursor.getColumnIndex("person_id")),
                cursor.getString(cursor.getColumnIndex("person_name")),
                cursor.getString(cursor.getColumnIndex("person_number")),
                cursor.getInt(cursor.getColumnIndex("person_age")),
                cursor.getDouble(cursor.getColumnIndex("person_height")))
            personsArrayList.add(person)
        }
        return personsArrayList
    }

    @SuppressLint("Range")
    fun RandomGetPerson(dbHelper:DBHelper) : ArrayList<Persons>{

        val personsArrayList = ArrayList<Persons>()
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM persons ORDER BY RANDOM() LIMIT 2",null)

        while (cursor.moveToNext()){
            val person = Persons(cursor.getInt(cursor.getColumnIndex("person_id")),
                cursor.getString(cursor.getColumnIndex("person_name")),
                cursor.getString(cursor.getColumnIndex("person_number")),
                cursor.getInt(cursor.getColumnIndex("person_age")),
                cursor.getDouble(cursor.getColumnIndex("person_height")))
            personsArrayList.add(person)
        }
        return personsArrayList
    }

    @SuppressLint("Range")
    fun SaveCheck(dbHelper:DBHelper,keyWord:String) : Int{
        var result = 0
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("SELECT count(*) AS result FROM persons WHERE person_name='$keyWord'",null)
        while (cursor.moveToNext()){
            result = cursor.getInt(cursor.getColumnIndex("result"))
        }


        return  result
    }

    @SuppressLint("Range")
    fun GetPerson(dbHelper:DBHelper,person_id:Int) : Persons? {

        var getPerson:Persons? = null
        val db = dbHelper.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM persons WHERE person_id=$person_id",null)

        while (cursor.moveToNext()){
            getPerson = Persons(cursor.getInt(cursor.getColumnIndex("person_id")),
                cursor.getString(cursor.getColumnIndex("person_name")),
                cursor.getString(cursor.getColumnIndex("person_number")),
                cursor.getInt(cursor.getColumnIndex("person_age")),
                cursor.getDouble(cursor.getColumnIndex("person_height")))
        }
        return getPerson
    }

}