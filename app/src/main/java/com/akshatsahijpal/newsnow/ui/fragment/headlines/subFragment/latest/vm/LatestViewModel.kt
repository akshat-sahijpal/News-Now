package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.latest.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.latest.LatestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class LatestViewModel @Inject constructor(private var repo: LatestRepository) : ViewModel() {
    fun getRefinedData(query: String = "publishedAt"): LiveData<PagingData<NewsData.Article>> {
        return repo.getLatest(query).cachedIn(viewModelScope)
    }
}