package com.nitla.shoestore.views.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nitla.shoestore.models.User
//import com.nitla.shoestore.models.User
import timber.log.Timber

class LoginViewModel : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user : LiveData<User>
        get() = _user
    val regex = """[a-zA-Z0-9._-]+@[a-z]+\.+[a-z]+""".toRegex()

    init {
        _user.value = User("")
        Timber.i("initialized")
    }
    fun validateEmail():Boolean{
        Timber.i("I WAS CALLED")
        return (regex matches (user.value?.email ?:""))
    }
}