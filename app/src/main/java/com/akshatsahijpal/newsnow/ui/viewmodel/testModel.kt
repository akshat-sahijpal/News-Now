package com.akshatsahijpal.newsnow.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akshatsahijpal.newsnow.api.NewsApi
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.db.local.NewsDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class testModel @Inject constructor(
    private var api: NewsApi,
    private var dao: NewsDao
) : ViewModel() {
    private var newsMutData: MutableLiveData<NewsData> = MutableLiveData()
    private var testData: MutableLiveData<List<NewsData>> = MutableLiveData()
    var data: LiveData<NewsData> = newsMutData

    init {
        viewModelScope.launch {
            val setD = api.getEveryNews("Death")
            newsMutData.value = setD
        }
    }

    fun store(set: NewsData) {
        viewModelScope.launch { dao.insert(set) }
    }

    fun etD() {
        viewModelScope.launch { var res = dao.getAllData()
            testData.value = res
        }
    }
    fun getD() = this.testData
}