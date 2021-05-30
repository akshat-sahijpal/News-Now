package com.akshatsahijpal.newsnow.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.NewsRefinedRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class RefinedViewModel @Inject constructor(private var repo:NewsRefinedRepository):  ViewModel() {
    fun getRefinedData(query: String): LiveData<PagingData< NewsData.Article>> {
        return repo.getRefinedData(query).cachedIn(viewModelScope)
    }
}