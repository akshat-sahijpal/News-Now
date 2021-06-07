package com.akshatsahijpal.newsnow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.akshatsahijpal.newsnow.repository.search.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class testModel @Inject constructor(
    private var repo: NewsRepository
) : ViewModel() {

   var data = repo.getAllDataOfType("Covid").asLiveData()
}