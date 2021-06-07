package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.technology

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshatsahijpal.newsnow.adapter.NewsAdapter
import com.akshatsahijpal.newsnow.databinding.FragmentTechnologyNewsBinding
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.technology.vm.TechViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TechnologyNewsFragment : Fragment() {
    private lateinit var _binding: FragmentTechnologyNewsBinding
    private var adapter = NewsAdapter()
    private val model by viewModels<TechViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTechnologyNewsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.apply {
            recyclerViewTi.adapter = adapter
            recyclerViewTi.layoutManager = LinearLayoutManager(requireContext())
            model.getRefinedData().observe(viewLifecycleOwner) {
                GlobalScope.launch { adapter.submitData(it) }
            }
        }
    }
}