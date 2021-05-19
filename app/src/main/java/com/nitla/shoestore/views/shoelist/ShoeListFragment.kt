package com.nitla.shoestore.views.shoelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginTop
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.nitla.shoestore.R
import com.nitla.shoestore.databinding.FragmentShoeListBinding
import com.nitla.shoestore.models.SharedShoeListViewModel
import com.nitla.shoestore.models.Shoe
import timber.log.Timber


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val model: SharedShoeListViewModel by activityViewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setHasOptionsMenu(true)
//
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_list,container,false)

        binding.floatingActionButton.setOnClickListener {
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }
        //TODO loop through each shoe and create a view
        model.shoeList.value?.forEach { shoe ->
            binding.shoeListLayout.addView(createShoeView(shoe))
        }
        findNavController().addOnDestinationChangedListener { controller, destination, arguments ->
            if(destination.id == controller.graph.startDestination){
                Timber.i("called in list")
                model.clearShoeInventory()
            }
        }

       //TODO: TEST TO SEE IF SHOES ARE ADDED CORRECLTY
        return binding.root
    }

    fun createShoeView(shoe: Shoe):View{
        val companyText = TextView(this.context)
        companyText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)
        companyText.setPadding(setDensityPixels(8),setDensityPixels(8),0,0)
        val shoeStyleText = TextView(this.context)

        shoeStyleText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)
        shoeStyleText.setPadding(setDensityPixels(8),setDensityPixels(8),0,0)

        val shoeSize = TextView(this.context)
        shoeSize.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)
        shoeSize.setPadding(setDensityPixels(8),setDensityPixels(8),0,0)

        val shoeDescriptionText = TextView(this.context)
        shoeDescriptionText.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)
        shoeDescriptionText.setPadding(setDensityPixels(8),setDensityPixels(8),setDensityPixels(8),0)

        shoe.apply {
            companyText.text = company
            shoeStyleText.text = name
            shoeSize.text = size.toString()
            shoeDescriptionText.text = description
        }
        var layout:LinearLayout = LinearLayout(this.context)
        val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT)
        params.setMargins(setDensityPixels(8),setDensityPixels(8),setDensityPixels(8),0)
        layout.layoutParams = params
        layout.orientation = LinearLayout.VERTICAL
        layout.addView(companyText)
        layout.addView(shoeStyleText)
        layout.addView(shoeSize)
        layout.addView(shoeDescriptionText)
        layout.setBackgroundResource(R.drawable.border)
        layout.elevation =  setDensityPixels(3).toFloat()

        return layout
    }
    fun setDensityPixels(pad:Int):Int{
        val density = this.context?.getResources()?.getDisplayMetrics()?.density
       return if(density != null){
            ((pad * density).toInt());
        } else 0
    }
}