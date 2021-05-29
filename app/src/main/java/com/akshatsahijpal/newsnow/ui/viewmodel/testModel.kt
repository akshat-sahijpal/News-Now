package com.akshatsahijpal.newsnow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.akshatsahijpal.newsnow.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class testModel @Inject constructor(
    private var repo: NewsRepository
) : ViewModel() {
/*    private var newsMutData: MutableLiveData<NewsData> = MutableLiveData()
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
    fun getD() = this.testData*/
   var data = repo.getAllDataOfType("Covid").asLiveData()
}