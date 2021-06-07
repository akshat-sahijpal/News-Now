package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.science.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.science.ScienceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SciViewModel @Inject constructor(private var repo: ScienceRepository)
    : ViewModel() {

    fun getRefinedData(query: String = "science"): LiveData<PagingData<NewsData.Article>> {
        return repo.getForScienceData(query).cachedIn(viewModelScope)
    }
}