package com.akshatsahijpal.newsnow.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshatsahijpal.newsnow.api.NewsApi
import com.akshatsahijpal.newsnow.data.NewsData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class testModel @Inject constructor(
    api: NewsApi
) : ViewModel() {
    private var newsMutData: MutableLiveData<NewsData> = MutableLiveData()
    var data: LiveData<NewsData> = newsMutData

    init {
        viewModelScope.launch {
            val setD = api.getEveryNews("Death")
            newsMutData.value = setD
        }
    }
}