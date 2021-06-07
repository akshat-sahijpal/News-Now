package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.health.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.health.HealthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HealthViewModel @Inject constructor(private var repo: HealthRepository) : ViewModel() {
    fun getRefinedData(query: String = "health"): LiveData<PagingData<NewsData.Article>> {
        return repo.getForHealthData(query).cachedIn(viewModelScope)
    }
}