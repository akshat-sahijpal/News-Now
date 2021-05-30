package com.akshatsahijpal.newsnow.repository.paginsource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.akshatsahijpal.newsnow.api.NewsApi
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.data.NewsRefinedData

class NewsPagingSource constructor(
    private var api: NewsApi,
    private var query: String
) : PagingSource<Int, NewsData.Article>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, NewsData.Article> {
        var currentPosition = params.key ?: 1
        return try {
            var data = api.getEveryNews(query)
            var res = data.articles
            LoadResult.Page(
                data = res,
                prevKey = if (currentPosition == 1) null else currentPosition - 1,
                nextKey = if (res.isEmpty()) null else currentPosition + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int,  NewsData.Article>): Int? {
        TODO("Not yet implemented")
    }
}