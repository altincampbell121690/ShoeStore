package com.nitla.shoestore.views.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nitla.shoestore.models.User
import java.lang.IllegalArgumentException

class WelcomeViewModelFactory(private val user: User) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WelcomeViewModel::class.java)){
            return WelcomeViewModel(user) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}