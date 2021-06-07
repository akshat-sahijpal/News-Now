package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.business.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.business.BusinessRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BusinessViewModel @Inject constructor(private var repo: BusinessRepository) : ViewModel() {
    fun getRefinedData(query: String = "business"): LiveData<PagingData<NewsData.Article>> {
        return repo.getForBusinessData(query).cachedIn(viewModelScope)
    }
}