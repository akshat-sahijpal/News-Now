package com.akshatsahijpal.newsnow.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "news_data_srt")
data class NewsData(
    @ColumnInfo(name = "articles") var articles: List<Article>,
    @ColumnInfo(name = "status") var status: String,
    @ColumnInfo(name = "totalResults") var totalResults: Int,
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
) {
    data class Article(
        @ColumnInfo(name = "author") var author: String,
        @ColumnInfo(name = "content") var content: String,
        @ColumnInfo(name = "description") var description: String,
        @ColumnInfo(name = "publishedAt") var publishedAt: String,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "url") var url: String,
        @ColumnInfo(name = "urlToImage") var urlToImage: String
    )
}