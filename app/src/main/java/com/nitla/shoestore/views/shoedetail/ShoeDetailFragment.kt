package com.nitla.shoestore.views.shoedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nitla.shoestore.R
import com.nitla.shoestore.databinding.FragmentShoeDetailBinding
import com.nitla.shoestore.models.SharedShoeListViewModel
import timber.log.Timber


class ShoeDetailFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: SharedShoeListViewModel by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.saveButton.setOnClickListener {
            saveShoe()
            navBackToShoeList()
        }

        binding.cancelButton.setOnClickListener {
            //TODO: navigate back to previous screen
            navBackToShoeList()
        }

        findNavController().addOnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id == controller.graph.startDestination){
                Timber.i("called in Details")
                viewModel.clearShoeInventory()
            }
        }
        return binding.root
    }

    private fun saveShoe() {
        binding.apply {
            viewModel.addShoe(
                name = shoeNameText.text.toString(),
                size = sizeText.text.toString(),
                company = companyText.text.toString(),
                description = descriptionText.text.toString()
            )
        }
    }


    private fun navBackToShoeList() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        findNavController().navigate(action)
    }
}