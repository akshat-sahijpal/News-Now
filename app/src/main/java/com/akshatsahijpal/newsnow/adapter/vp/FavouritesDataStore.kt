package com.akshatsahijpal.newsnow.adapter.vp

import androidx.lifecycle.MutableLiveData
import com.akshatsahijpal.newsnow.data.NewsData

class FavouritesDataStore {
    private var  rtf :ArrayList<NewsData.Article> = ArrayList()
    private var dataSet: MutableLiveData<ArrayList<NewsData.Article>> = MutableLiveData()
    fun save(content: NewsData.Article) {
        rtf.add(content)
        dataSet.value = rtf
    }
    fun getSavedData():MutableLiveData<ArrayList<NewsData.Article>>{
        return this.dataSet
    }
}