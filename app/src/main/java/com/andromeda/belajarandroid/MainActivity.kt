package com.andromeda.belajarandroid

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    private lateinit var text1: TextView
    private lateinit var btn1: Button
    private lateinit var btnPhone: Button
    private lateinit var btnFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.text1)
        btn1 = findViewById(R.id.btn1)
        btnPhone = findViewById(R.id.btn_phone)
        btnFragment = findViewById(R.id.btn_fragment)

        // EXPLICIT INTENT
        btn1.setOnClickListener {
            // Open MainActivity2
            val intentDestination = Intent(this@MainActivity, MainActivity2::class.java)
            // intentDestination.putExtra(MainActivity2.EXTRA_DATA, "Hello My Friend")
            intentDestination.putExtra(MainActivity2.EXTRA_DATA, Student("kotlin-parcelize", "12345"))
            // startActivity(intentDestination)

            resultLauncher.launch(intentDestination)
        }

        // IMPLICIT INTENT
        btnPhone.setOnClickListener {
            val number = "12345678"
            val intentPhone = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")) // don't forget tel:
            startActivity(intentPhone)
        }

        btnFragment.setOnClickListener {
            val intentDestination = Intent(this@MainActivity, FragmentActivity::class.java)
            startActivity(intentDestination)
        }
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result -> if (result.resultCode == MainActivity2.RESULT_CODE && result.data != null) {
                val name = result.data?.getStringExtra(MainActivity2.EXTRA_RETRUN_VALUE)
                Toast.makeText(applicationContext, name, Toast.LENGTH_LONG).show()
            }
    }
}