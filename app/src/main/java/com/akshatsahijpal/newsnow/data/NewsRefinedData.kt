package com.akshatsahijpal.newsnow.data

import androidx.room.PrimaryKey


data class NewsRefinedData(
    var author: String,
    var content: String,
    var description: String,
    var publishedAt: String,
    var title: String,
    var url: String,
    var urlToImage: String,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
)
