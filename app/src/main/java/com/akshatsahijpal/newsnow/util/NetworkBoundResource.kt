package com.akshatsahijpal.newsnow.util

import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>, // from local database
    crossinline fetch: suspend () -> RequestType, // get from remote
    crossinline  saveFetchedData: suspend (RequestType) -> Unit, // save new data to local db
    crossinline  shouldFetch: (ResultType) -> Boolean = {
        true
    }// is data stale?
) = flow {
    var data = query().first() // from local db
     var flowSet =  if (shouldFetch(data)) { // if the data is stale
        emit(Resource.Loading(data)) // emit a loading screen
        try {
            saveFetchedData(fetch()) // get new data from the server and save it to local database
            query().map {
                Resource.Success(it)
            }
        } catch (throwable: Throwable) {
            query().map {
                Resource.Error(throwable, it)
            }
        }
    }else{
        query().map {
            Resource.Success(it)
        }
    }
    emitAll(flowSet)
}