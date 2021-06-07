package com.akshatsahijpal.newsnow.repository.sub.world

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.akshatsahijpal.newsnow.api.NewsApi
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.repository.sub.world.pagingsource.WorldPagingSource
import javax.inject.Inject

class WorldRepository @Inject constructor(
    private var api: NewsApi
) {
    fun getForWorldData(query: String = "world"): LiveData<PagingData<NewsData.Article>> {
        return Pager(
            config = PagingConfig(
                pageSize = 4,
                enablePlaceholders = true,
                initialLoadSize = 4,
                maxSize = 20
            ),
            pagingSourceFactory = {
                WorldPagingSource(api, query)
            }
        ).liveData
    }
}