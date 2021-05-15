package com.nitla.shoestore.views.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.nitla.shoestore.R
import com.nitla.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentInstructionBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction, container, false)
        return binding.root
    }

}