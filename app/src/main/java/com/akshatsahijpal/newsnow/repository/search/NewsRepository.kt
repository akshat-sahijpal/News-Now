package com.akshatsahijpal.newsnow.repository.search

import androidx.room.withTransaction
import com.akshatsahijpal.newsnow.api.NewsApi
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.db.local.NewsDao
import com.akshatsahijpal.newsnow.db.local.NewsDataBase
import com.akshatsahijpal.newsnow.util.Resource
import com.akshatsahijpal.newsnow.util.networkBoundResource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private var dao: NewsDao,
    private var api: NewsApi,
    private var db: NewsDataBase
) {
    fun getAllDataOfType(query: String): Flow<Resource<List<NewsData>>> {
       return networkBoundResource(
            query = {
                dao.getCachedData()
            },
            fetch = {
                api.getEveryNews(query)
            },
            saveFetchedData = {
                db.withTransaction {
                    dao.deleteAll()
                    dao.insert(it)
                }
            }
        )
    }
}