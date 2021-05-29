package com.akshatsahijpal.newsnow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.akshatsahijpal.newsnow.ui.viewmodel.testModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val model by viewModels<testModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model.data.observe(this){
            var set = it.data?.get(0)?.articles?.get(0)?.content
            Toast.makeText(applicationContext, "data ->$set", Toast.LENGTH_SHORT).show()
        }
    }
}