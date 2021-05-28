package com.akshatsahijpal.newsnow.db.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.akshatsahijpal.newsnow.data.NewsData
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: NewsData)

    @Query("SELECT * FROM news_data_srt ")
    suspend fun getAllData() : List<NewsData>

    @Query("SELECT * FROM news_data_srt WHERE status == 'ok' ")
     fun getCachedData(): Flow<List<NewsData>>
}