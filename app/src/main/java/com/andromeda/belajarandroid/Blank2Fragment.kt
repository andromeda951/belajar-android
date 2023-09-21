package com.andromeda.belajarandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andromeda.belajarandroid.databinding.FragmentBlank2Binding

class Blank2Fragment : Fragment() {

    companion object {
        val EXTRA_VALUE = "extra_value"
    }

    private lateinit var binding: FragmentBlank2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_blank2, container, false)
        binding = FragmentBlank2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myText.text = arguments?.getString(EXTRA_VALUE)

        val fragment1 = Blank1Fragment()
        binding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_container, fragment1, Blank1Fragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}