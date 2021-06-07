package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.technology.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.tech.TechRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class TechViewModel @Inject constructor(private var repo: TechRepository) : ViewModel() {

    fun getRefinedData(query: String = "technology"): LiveData<PagingData<NewsData.Article>> {
        return repo.getForTechData(query).cachedIn(viewModelScope)
    }
}