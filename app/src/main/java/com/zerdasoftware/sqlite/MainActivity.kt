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
        //PersonsDAO().PersonUpdate(dbHelper,persons)
        //PersonsDAO().PersonDelete(dbHelper,1)
        //val personList = PersonsDAO().AllPerson(dbHelper)
        //val personList = PersonsDAO().PersonSerach(dbHelper,"Cihan")
        //val personList = PersonsDAO().RandomGetPerson(dbHelper)
        //val result = PersonsDAO().SaveCheck(dbHelper,"Cihan Çallı")
        val person = PersonsDAO().GetPerson(dbHelper,2)
        Log.e("ID ",person?.person_id.toString())
        Log.e("Name ",person?.person_name.toString())
        Log.e("Number ",person?.person_number.toString())
        Log.e("Age ",person?.person_age.toString())
        Log.e("Height ",person?.person_height.toString())

        //Log.e("result ",result.toString())
        /*
        for (p in personList){
            Log.e("*******","*******")
            Log.e("ID ",p.person_id.toString())
            Log.e("Name ",p.person_name)
            Log.e("Number ",p.person_number)
            Log.e("Age ",p.person_age.toString())
            Log.e("Height ",p.person_height.toString())
        }
         */

    }
}