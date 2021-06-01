package com.akshatsahijpal.newsnow.repository

import com.akshatsahijpal.newsnow.db.local.NewsDao
import javax.inject.Inject

class FavouritesRepository @Inject constructor(
    private var dao: NewsDao
) {
    fun InsertFav() {

    }
}