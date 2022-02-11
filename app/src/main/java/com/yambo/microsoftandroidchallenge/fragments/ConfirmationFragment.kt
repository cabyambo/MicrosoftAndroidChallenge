package com.yambo.microsoftandroidchallenge.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yambo.microsoftandroidchallenge.databinding.ConfirmationFragmentBinding

class ConfirmationFragment: Fragment() {
    private var _binding: ConfirmationFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = ConfirmationFragmentBinding.inflate(inflater, container, false)

        updateUi()

        return binding.root
    }

    private fun updateUi() {

        val name = arguments?.getString("name")
        val website = arguments?.getString("website")
        val email = arguments?.getString("email")

        binding.confirmationHeader.text = name
        binding.websiteOutput.text = website
        binding.nameOutput.text = name
        binding.emailOutput.text = email

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}