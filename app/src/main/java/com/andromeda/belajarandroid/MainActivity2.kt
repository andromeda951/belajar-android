package com.andromeda.belajarandroid

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data_key"
        const val EXTRA_RETRUN_VALUE = "extra_return_value"
        const val RESULT_CODE = 110
    }

    private lateinit var text1: TextView
    private lateinit var editName: EditText
    private lateinit var buttonSubmit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        text1 = findViewById(R.id.textView)
        editName = findViewById(R.id.edit_name)
        buttonSubmit = findViewById(R.id.button_submit)

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

        buttonSubmit.setOnClickListener {
            val name = editName.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_RETRUN_VALUE, name)
            setResult(RESULT_CODE, resultIntent)
            finish()
        }
    }
}