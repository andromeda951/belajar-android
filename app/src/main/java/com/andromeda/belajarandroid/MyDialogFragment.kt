package com.andromeda.belajarandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.andromeda.belajarandroid.databinding.FragmentMyDialogBinding

class MyDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentMyDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_my_dialog, container, false)
        binding = FragmentMyDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

}