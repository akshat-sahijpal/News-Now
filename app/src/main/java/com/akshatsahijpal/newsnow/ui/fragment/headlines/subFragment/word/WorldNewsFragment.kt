package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.word

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshatsahijpal.newsnow.adapter.NewsAdapter
import com.akshatsahijpal.newsnow.databinding.FragmentWorldNewsBinding
import com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.word.vm.WorldViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WorldNewsFragment : Fragment() {
    private lateinit var _binding: FragmentWorldNewsBinding
    private var adapter = NewsAdapter()
    private val model by viewModels<WorldViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorldNewsBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.apply {
            recyclerViewWi.adapter = adapter
            recyclerViewWi.layoutManager = LinearLayoutManager(requireContext())
            model.getRefinedData().observe(viewLifecycleOwner) {
                GlobalScope.launch { adapter.submitData(it) }
            }
        }
    }
}