package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akshatsahijpal.newsnow.databinding.FragmentCountrySpecificNewsBinding

class CountrySpecificNewsFragment : Fragment() {
    private lateinit var _binding: FragmentCountrySpecificNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountrySpecificNewsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}