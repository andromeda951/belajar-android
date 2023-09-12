package com.andromeda.belajarandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var text1: TextView
    private lateinit var btn1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.text1)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {
            // Open MainActivity2
            val intentDestination = Intent(this@MainActivity, MainActivity2::class.java)
            intentDestination.putExtra(MainActivity2.EXTRA_DATA, "Hello My Friend")
            startActivity(intentDestination)
        }
    }
}