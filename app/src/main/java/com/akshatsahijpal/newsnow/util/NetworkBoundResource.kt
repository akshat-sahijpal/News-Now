package com.akshatsahijpal.newsnow.util

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import java.lang.Exception

fun <ResultType, RequestType> networkBoundResource(
    query: () -> Flow<ResultType>, // from local database
    fetch: suspend () -> RequestType, // get from remote
    saveFetchedData: suspend (RequestType) -> Unit, // save new data to local db
    shouldFetch: (ResultType) -> Boolean = { true }// is data stale?
) = flow {
    var data = query().first() // from local db
    if (shouldFetch(data)) { // if the data is stale
        emit(Resource.Loading(data)) // emit a loading screen
        try {
            saveFetchedData(fetch()) // get new data from the server and save it to local database}
        } catch (throwable: Throwable) {

        }
    }
}