package com.yambo.microsoftandroidchallenge.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.yambo.microsoftandroidchallenge.R
import com.yambo.microsoftandroidchallenge.databinding.SignUpFragmentBinding
import com.yambo.microsoftandroidchallenge.viewmodels.AuthenticationViewModel

class SignUpFragment: Fragment() {

    private var _binding: SignUpFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AuthenticationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = SignUpFragmentBinding.inflate(inflater, container, false)

        setupObservers()
        setupButtonHandlers()

        return binding.root
    }


    private fun setupObservers() {
        binding.nameInput.addTextChangedListener { name ->
            viewModel.name.value = name.toString()
        }

        binding.emailInput.addTextChangedListener { email ->
            viewModel.email.value = email.toString()
            Log.d("TAGyolo", viewModel.email.value.toString())
        }

        binding.passwordInput.addTextChangedListener { password ->
            viewModel.password.value = password.toString()
        }

        binding.websiteInput.addTextChangedListener { website ->
            viewModel.website.value = website.toString()
        }

        viewModel.isFormValid.observe(this, { isValidated ->
            if (isValidated) {
                binding.button.isEnabled = true
                binding.button.alpha = 1.0f
            } else {
                binding.button.isEnabled = false
                binding.button.alpha = 1.0f
            }
        })
    }

    private fun setupButtonHandlers() {
        binding.button.setOnClickListener {
            loadConfirmationFragment()
        }
    }

    private fun loadConfirmationFragment() {
        Log.d("TAGyolo", viewModel.email.value.toString() + " first")
        val fragmentManager = parentFragmentManager

        val confirmationFragment = ConfirmationFragment()

        fragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragmentContainerView, confirmationFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}