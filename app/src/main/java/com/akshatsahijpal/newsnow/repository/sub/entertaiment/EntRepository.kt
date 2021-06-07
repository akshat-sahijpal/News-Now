package com.akshatsahijpal.newsnow.repository.sub.entertaiment

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.akshatsahijpal.newsnow.api.NewsApi
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.pagingsource.SubFragPagingSource
import javax.inject.Inject

class EntRepository  @Inject constructor(
    private var api: NewsApi
){
    fun getForEnter(query: String): LiveData<PagingData<NewsData.Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = 4,
                enablePlaceholders = true,
                initialLoadSize = 4,
                maxSize = 20
            ),
            pagingSourceFactory = {
                SubFragPagingSource(api, query)
            }
        ).liveData
    }
}