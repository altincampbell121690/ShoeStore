package com.nitla.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nitla.shoestore.models.Shoe

@Suppress("UNCHECKED_CAST")
class SharedShoeListViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList as LiveData<List<Shoe>>

    init {
        _shoeList.value = mutableListOf()
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }
    fun clearShoeInventory(){
        _shoeList.value = mutableListOf()
    }
    fun addShoe(name: String, size: String, company: String, description: String) {
        addShoe(Shoe(
                name = name,
                size = size.toDouble(),
                company = company,
                description = description
            ))
    }

}