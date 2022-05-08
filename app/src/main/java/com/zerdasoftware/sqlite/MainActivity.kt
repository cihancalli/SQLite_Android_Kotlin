package com.zerdasoftware.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DBHelper(this)

        var persons = Persons(2,
            "Cihan Çallı",
            "05450000001",
            29,
            1.55)

        //PersonsDAO().PersonAdd(dbHelper,persons)
        PersonsDAO().PersonUpdate(dbHelper,persons)
        val personList = PersonsDAO().AllPerson(dbHelper)

        for (p in personList){
            Log.e("*******","*******")
            Log.e("ID ",p.person_id.toString())
            Log.e("Name ",p.person_name)
            Log.e("Number ",p.person_number)
            Log.e("Age ",p.person_age.toString())
            Log.e("Height ",p.person_height.toString())
        }

    }
}