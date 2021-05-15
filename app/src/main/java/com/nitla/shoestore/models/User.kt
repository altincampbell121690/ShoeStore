package com.nitla.shoestore.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    var email: String
) : Parcelable{
    private var userName : String? = null
    fun getUserName():String{
        return if(email.isEmpty()){
            ""
        }else {
            if (userName.isNullOrEmpty()) {
                userName = email.split("@")[0]
            }
            userName!!
        }
    }

}