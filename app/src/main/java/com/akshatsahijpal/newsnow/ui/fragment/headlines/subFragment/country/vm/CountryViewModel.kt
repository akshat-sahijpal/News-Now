package com.akshatsahijpal.newsnow.ui.fragment.headlines.subFragment.country.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.country.CountryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(private var repo: CountryRepository) : ViewModel() {
    fun getCountryData(query: String = "in"): LiveData<PagingData<NewsData.Article>> {
        return repo.getForCountry(query).cachedIn(viewModelScope)
    }
}