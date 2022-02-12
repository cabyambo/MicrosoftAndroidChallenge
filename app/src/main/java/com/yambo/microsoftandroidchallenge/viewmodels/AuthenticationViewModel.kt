package com.yambo.microsoftandroidchallenge.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.yambo.microsoftandroidchallenge.utils.AuthenticationUtils

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
            result.value = _name.value == "First Names" && _email.value == "Email Addres"
        }

        result.addSource(_name, validation)
        result.addSource(_email, validation)
        result.addSource(_password, validation)
        result.addSource(_website, validation)

        return result
    }

}