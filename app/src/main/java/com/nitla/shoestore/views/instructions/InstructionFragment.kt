package com.nitla.shoestore.views.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.nitla.shoestore.R
import com.nitla.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding : FragmentInstructionBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction, container, false)
        binding.shopButton.setOnClickListener {
            val action = InstructionFragmentDirections.actionInstructionDestinationToShoeListFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }

}