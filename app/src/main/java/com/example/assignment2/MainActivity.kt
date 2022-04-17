package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater as MenuInflater1
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*



var flag : String = "apple juice"
var price: Int = 0
var x:Int = 0
var result: Int =0
var total:String = ""


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ratingTV: TextView = findViewById(R.id.Rating)
        ratingTV.setOnClickListener {
            var dialog_var = CdialogFragment()
            dialog_var.show(supportFragmentManager, "Custom Dialog")

            val number: EditText = findViewById(R.id.editTextNumber)
            val iTEMS: Spinner = findViewById(R.id.spinner)
            var options = arrayOf("apple juice","hashbrowns","banana","kiwi")
            iTEMS.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
            iTEMS.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    flag = options.get(p2)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
            if (flag == "apple juice")
                price = 99
            else if (flag == "hashbrowns")
                price = 12
            else if (flag == "banana")
                price = 3
            else
                price = 5
            x = number.text.toString().toInt()
            result = x * price
            total = " total is: " + result.toString() + "JD"
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item1 -> Toast.makeText(this, "the total is ${result.toString()}", Toast.LENGTH_LONG).show()
            R.id.subitem2 -> Toast.makeText(this, "okay and?", Toast.LENGTH_SHORT).show()
            R.id.subitem1 -> Toast.makeText(this, "welp :)", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}