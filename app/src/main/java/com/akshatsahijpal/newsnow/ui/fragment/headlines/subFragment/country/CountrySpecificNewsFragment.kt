package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshatsahijpal.newsnow.adapter.NewsAdapter
import com.akshatsahijpal.newsnow.databinding.FragmentCountrySpecificNewsBinding
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.country.vm.CountryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CountrySpecificNewsFragment : Fragment() {
    private var adapter = NewsAdapter()
    private val model by viewModels<CountryViewModel>()
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
        _binding.apply {
            recyclerViewCi.adapter = adapter
            recyclerViewCi.layoutManager = LinearLayoutManager(requireContext())
            model.getCountryData().observe(viewLifecycleOwner) {
                GlobalScope.launch { adapter.submitData(it) }
            }
        }
    }
}