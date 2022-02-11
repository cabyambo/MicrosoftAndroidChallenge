package com.yambo.microsoftandroidchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.yambo.microsoftandroidchallenge.R
import com.yambo.microsoftandroidchallenge.databinding.SignUpFragmentBinding

class SignUpFragment: Fragment() {

    private var _binding: SignUpFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = SignUpFragmentBinding.inflate(inflater, container, false)

        setupButtonHandlers()

        return binding.root
    }

    private fun setupButtonHandlers() {
        binding.button.setOnClickListener {
            loadConfirmationFragment()
        }
    }

    private fun loadConfirmationFragment() {
        val fragmentManager = parentFragmentManager

        val args: Bundle = bundleOf(
            "name" to "jason",
            "website" to "www.website.com",
            "email" to "test@email.com"
        )

        val confirmationFragment = ConfirmationFragment()
        confirmationFragment.arguments = args

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