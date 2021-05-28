package com.akshatsahijpal.newsnow.di

import android.content.Context
import androidx.room.Room
import com.akshatsahijpal.newsnow.api.NewsApi
import com.akshatsahijpal.newsnow.db.local.NewsDataBase
import com.akshatsahijpal.newsnow.util.Constants
import com.akshatsahijpal.newsnow.util.Constants.DATA_BASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationInjectorObj {
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideNesApi(retro: Retrofit): NewsApi =
        retro.create(NewsApi::class.java)

    @Singleton
    @Provides
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        NewsDataBase::class.java,
        DATA_BASE
    )
        .build()

    @Singleton
    @Provides
    fun provideRunDao(db: NewsDataBase) = db.getRunDao()
}