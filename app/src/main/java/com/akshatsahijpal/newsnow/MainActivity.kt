package com.akshatsahijpal.newsnow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.akshatsahijpal.newsnow.adapter.NewsAdapter
import com.akshatsahijpal.newsnow.api.NewsApi
import com.akshatsahijpal.newsnow.databinding.ActivityMainBinding
import com.akshatsahijpal.newsnow.ui.viewmodel.RefinedViewModel
import com.akshatsahijpal.newsnow.ui.viewmodel.testModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var adapter= NewsAdapter()
    private lateinit var _binding: ActivityMainBinding
    private val model by viewModels<RefinedViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _binding.apply {
            recyclerView404.adapter = adapter
            recyclerView404.layoutManager = LinearLayoutManager(applicationContext)
        }
        model.getRefinedData("Covid").observe(this){
            GlobalScope.launch{ adapter.submitData(it) }
        }
    }
}