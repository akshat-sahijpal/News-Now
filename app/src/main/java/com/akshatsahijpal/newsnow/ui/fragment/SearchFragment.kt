package com.akshatsahijpal.newsnow.ui.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshatsahijpal.newsnow.adapter.NewsAdapter
import com.akshatsahijpal.newsnow.databinding.FragmentSearchBinding
import com.akshatsahijpal.newsnow.databinding.SrIndexChipsBinding
import com.akshatsahijpal.newsnow.ui.viewmodel.RefinedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var adapter = NewsAdapter()
    private var key_string: String = "com.akshatsahijpal.newsnow.ui.fragment"
    private var defVal: String? = null
    private lateinit var _binding: FragmentSearchBinding
    private val model by viewModels<RefinedViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defVal = savedInstanceState?.getString(key_string)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        designSearchTab()
        _binding.apply {
            recyclerViewA.adapter = adapter
            recyclerViewA.layoutManager = LinearLayoutManager(requireContext())
            SearchFieldT.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
                override fun afterTextChanged(s: Editable?) {
                    defVal = s.toString()
                    _binding.chipGrp.isVisible = false
                    _binding.scroller.isVisible = false
                    _binding.Filter.isVisible = false
                    model.getRefinedData(
                        savedInstanceState?.getString(key_string) ?: s?.trim().toString()
                    ).observe(viewLifecycleOwner) {
                        GlobalScope.launch { adapter.submitData(it) }
                    }
                }
            })
        }
    }

    private fun designSearchTab() {
//        business entertainment health science sports technology
        setCategoryChips(arrayListOf("business", "entertainment", "health", "science", "sports", "technology "))

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Toast.makeText(requireContext(), "Triggered with $defVal", Toast.LENGTH_SHORT).show()
        outState.putString(key_string, defVal)
    }

    fun setCategoryChips(categorys: ArrayList<String?>) {
        for (category in categorys) {
            val mChip = SrIndexChipsBinding.inflate(layoutInflater).root
            mChip.text = category
            mChip.setOnCheckedChangeListener { button, isChecked ->
                if (isChecked) {
                    _binding.SearchFieldT.setText(button.text)
                }
            }
            _binding.chipGrp.addView(mChip)
        }
    }
}