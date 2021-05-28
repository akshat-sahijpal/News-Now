package com.akshatsahijpal.newsnow.db.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akshatsahijpal.newsnow.data.NewsData

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: NewsData)

    @Query("SELECT * FROM news_data_srt ")
    suspend fun getAllData() : List<NewsData>
}