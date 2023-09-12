package com.andromeda.belajarandroid

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data_key"
    }

    private lateinit var text1: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        text1 = findViewById(R.id.textView)

        Log.i("TAG", "version ${Build.VERSION.SDK_INT}")

        val student = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_DATA, Student::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_DATA)
        }

        if (student != null) {
            text1.text = student.name
        }
    }
}