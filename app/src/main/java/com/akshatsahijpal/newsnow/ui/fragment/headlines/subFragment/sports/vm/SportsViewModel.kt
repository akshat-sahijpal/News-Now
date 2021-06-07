package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.sports.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.sports.SportsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SportsViewModel @Inject constructor(private var repo: SportsRepository) : ViewModel() {

    fun getRefinedData(query: String = "sports"): LiveData<PagingData<NewsData.Article>> {
        return repo.getForSportsData(query).cachedIn(viewModelScope)
    }
}