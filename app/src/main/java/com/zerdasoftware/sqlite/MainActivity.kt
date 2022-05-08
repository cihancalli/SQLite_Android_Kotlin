package com.zerdasoftware.sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = DBHelper(this)

        var persons = Persons(1,
            "Cihan",
            "05350000000",
            21,
            1.75)

        PersonsDAO().PersonAdd(dbHelper,persons)
    }
}