package com.yambo.microsoftandroidchallenge.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.yambo.microsoftandroidchallenge.utils.AuthenticationUtils

/**
 * Shared ViewModel for
 * storing authentication
 * data
 */
class AuthenticationViewModel: ViewModel() {
    val name: MutableLiveData<String> = MutableLiveData("")
    val email: MutableLiveData<String> = MutableLiveData("")
    val password: MutableLiveData<String> = MutableLiveData("")
    val website: MutableLiveData<String> = MutableLiveData("")

    val isFormValid: LiveData<Boolean> = validateInput(name, email, password, website)

    private fun validateInput(
        _name: LiveData<String>,
        _email: LiveData<String>,
        _password: LiveData<String>,
        _website: LiveData<String>): LiveData<Boolean> {

        val result = MediatorLiveData<Boolean>()

        val validation = Observer<String> {
            // Name is always valid
            val validEmail = AuthenticationUtils.isValidEmail(_email.value.toString())
            val validPassword = AuthenticationUtils.isValidPassword(_password.value.toString())
            val validWebsite = _website.value!!.isEmpty() || AuthenticationUtils.isValidWebsite(_website.value.toString())

            result.value = validEmail && validPassword && validWebsite
        }

        result.addSource(_name, validation)
        result.addSource(_email, validation)
        result.addSource(_password, validation)
        result.addSource(_website, validation)

        return result
    }

    fun getConfirmationHeader(): String {
        var header = "Hello"
        if (!name.value!!.isEmpty()) {
            header += ", ${name.value}"
        }
        header += "!"
        return header
    }

}