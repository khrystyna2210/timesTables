package com.example.timestables

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textNumber: TextView
    private lateinit var seekBar: SeekBar
    private lateinit var listView: ListView
    private var numberArray = arrayListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    private fun init(){
        textNumber = findViewById(R.id.textNumber)
        seekBar = findViewById(R.id.seekBar)
        listView = findViewById(R.id.listView)

        textNumber.text = "Number"
        seekBar.max = 12

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                generateTimesNumber(p1)
                textNumber.text = p1.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        generateTimesNumber(5)
        textNumber.text = "5"
        seekBar.setProgress(5)
    }

    fun generateTimesNumber(num: Int){
        var numberArray = arrayListOf<String>()
        for(i in 1..10){
            numberArray.add("$i x $num = ${i*num}");
        }
        var listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, numberArray);
        listView.setAdapter(listAdapter);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
}