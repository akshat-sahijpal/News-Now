package com.akshatsahijpal.newsnow.db.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.akshatsahijpal.newsnow.data.NewsData
import com.akshatsahijpal.newsnow.util.Converter

@Database(
    entities = [NewsData::class],
    version = 1,
)
@TypeConverters(Converter::class)
abstract class NewsDataBase : RoomDatabase() {
    abstract fun getRunDao(): NewsDao
}