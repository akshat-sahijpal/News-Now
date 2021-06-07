package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.entertainment.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.entertaiment.EntRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EnterViewModel @Inject constructor(private var repo: EntRepository) : ViewModel() {
    fun getRefinedData(query: String = "entertainment"): LiveData<PagingData<NewsData.Article>> {
        return repo.getForEnter(query).cachedIn(viewModelScope)
    }
}