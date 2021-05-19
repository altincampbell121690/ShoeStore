package com.nitla.shoestore.views.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.nitla.shoestore.R
import com.nitla.shoestore.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {

    //create viewModel
    //create viewModelFactory
    private lateinit var viewModel: WelcomeViewModel
    private lateinit var viewModelFactory: WelcomeViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //TODO (get binding reference)
        val binding : FragmentWelcomeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)
        //TODO (get passed in arugment from previous screen -> user in this case)
        val welcomArgs by navArgs<WelcomeFragmentArgs>()
        //TODO (set viewModel using viewModelFactory)
        viewModelFactory = WelcomeViewModelFactory(welcomArgs.user)
        //TODO (set ViewModelFactory)
        viewModel = ViewModelProvider(this,viewModelFactory).get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = viewModel

        binding.findYourFreshButton.setOnClickListener{
            onInstructionNavigation()
        }
        return binding.root
    }

    fun onInstructionNavigation(){
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment()
        findNavController().navigate(action)
    }
}