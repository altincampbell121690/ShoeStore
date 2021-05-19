package com.nitla.shoestore.views.login

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.nitla.shoestore.R
import com.nitla.shoestore.databinding.FragmentLoginBinding
import com.nitla.shoestore.models.User
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        //TODO set up viewModel
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.loginViewModel = viewModel
        binding.lifecycleOwner = this

        binding.loginButton.setOnClickListener { onWelcomeNavigation() }

        binding.signupButton.setOnClickListener { onWelcomeNavigation() }

        binding.emailText.addTextChangedListener( getTextChangedListener() )

        viewModel.user.observe(this.viewLifecycleOwner, {
            Timber.i("I WAS CALLED to OBSERVE")
            binding.loginButton.isClickable = viewModel.validateEmail()
        })
        return binding.root
    }


    fun onWelcomeNavigation(){
        val action =
            LoginFragmentDirections.actionLoginDestinationToWelcomeFragment(viewModel.user.value
                ?: User("null@yahoo.com"))
        Timber.i("USER NAME: ${viewModel.user.value ?: "NULL "}")
        findNavController().navigate(action)
    }


    fun getTextChangedListener():TextWatcher{
        return object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Timber.i("I WAS CALLED to change text")
                binding.loginButton.isClickable = viewModel.validateEmail()
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        }
    }
}