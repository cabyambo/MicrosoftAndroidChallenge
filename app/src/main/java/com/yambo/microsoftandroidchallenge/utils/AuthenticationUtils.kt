package com.yambo.microsoftandroidchallenge.utils

import android.util.Patterns
import android.webkit.URLUtil

object AuthenticationUtils {
    fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun isValidWebsite(website: String): Boolean {
        return website.isNotEmpty() && Patterns.WEB_URL.matcher(website).matches()
    }
}