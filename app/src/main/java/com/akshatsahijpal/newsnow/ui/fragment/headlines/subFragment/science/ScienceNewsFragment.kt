package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.science

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshatsahijpal.newsnow.adapter.NewsAdapter
import com.akshatsahijpal.newsnow.databinding.FragmentScienceNewsBinding
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.science.vm.SciViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ScienceNewsFragment : Fragment() {
    private lateinit var _binding: FragmentScienceNewsBinding
    private var adapter = NewsAdapter()
    private val model by viewModels<SciViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScienceNewsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.apply {
            recyclerViewSi.adapter = adapter
            recyclerViewSi.layoutManager = LinearLayoutManager(requireContext())
            model.getRefinedData().observe(viewLifecycleOwner) {
                GlobalScope.launch { adapter.submitData(it) }
            }
        }
    }
}