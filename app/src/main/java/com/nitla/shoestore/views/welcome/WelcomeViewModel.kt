package com.nitla.shoestore.views.welcome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nitla.shoestore.models.User

class WelcomeViewModel(user: User):ViewModel() {
    private val _user = MutableLiveData<User>()
    val user : LiveData<User>
        get() = _user

    init {
        _user.value = user
    }
}