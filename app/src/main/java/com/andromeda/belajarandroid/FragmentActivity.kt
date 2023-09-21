package com.andromeda.belajarandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andromeda.belajarandroid.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment1 = Blank1Fragment()
        val fragment = supportFragmentManager.findFragmentByTag(Blank1Fragment::class.java.simpleName)

        if (fragment !is Blank1Fragment) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment1, Blank1Fragment::class.java.simpleName)
                .commit()
        }


    }
}