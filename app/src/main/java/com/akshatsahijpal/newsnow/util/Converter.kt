package com.akshatsahijpal.newsnow.util

import androidx.room.TypeConverter
import com.akshatsahijpal.newsnow.data.NewsData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converter {
    @TypeConverter
    fun fromArticleList(foodItems: List<NewsData.Article>): String {
        val gson = Gson()
        return gson.toJson(foodItems)
    }
    @TypeConverter
    fun stringToFoodItem(data: String): List<NewsData.Article> {
        val gson = Gson()
        val listType = object : TypeToken<List<NewsData.Article>>() {
        }.type
        return gson.fromJson(data, listType)
    }
}