package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.word.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.world.WorldRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class WorldViewModel @Inject constructor(private var repo: WorldRepository) : ViewModel() {
    fun getRefinedData(query: String = "technology"): LiveData<PagingData<NewsData.Article>> {
        return repo.getForWorldData(query).cachedIn(viewModelScope)
    }
}