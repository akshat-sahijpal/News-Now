package com.akshatsahijpal.newsnow.data

import androidx.room.PrimaryKey

data class NewsData(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    data class Article(
        val author: String,
        val content: String,
        val description: String,
        val publishedAt: String,
        val source: Source,
        val title: String,
        val url: String,
        val urlToImage: String
    ) {
        data class Source(
            val id: Any,
            val name: String
        )
    }
}