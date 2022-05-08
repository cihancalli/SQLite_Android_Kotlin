package com.zerdasoftware.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DBHelper(this)

        var persons = Persons(1,
            "Çallı",
            "05450000000",
            27,
            1.65)

        //PersonsDAO().PersonAdd(dbHelper,persons)
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