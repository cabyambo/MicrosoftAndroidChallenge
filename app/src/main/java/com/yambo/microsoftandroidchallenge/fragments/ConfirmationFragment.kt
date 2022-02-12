package com.yambo.microsoftandroidchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.yambo.microsoftandroidchallenge.databinding.ConfirmationFragmentBinding
import com.yambo.microsoftandroidchallenge.viewmodels.AuthenticationViewModel

class ConfirmationFragment: Fragment() {
    private var _binding: ConfirmationFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthenticationViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = ConfirmationFragmentBinding.inflate(inflater, container, false)

        updateUi()

        return binding.root
    }

    private fun updateUi() {
        binding.confirmationHeader.text = viewModel.name.value
        binding.websiteOutput.text = viewModel.website.value
        binding.nameOutput.text = viewModel.name.value
        binding.emailOutput.text = viewModel.email.value
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}