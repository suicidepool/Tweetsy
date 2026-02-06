package com.oms.tweetsy.api

import com.oms.tweetsy.model.CategoriesResponse
import com.oms.tweetsy.model.TweetListRecord
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface RetrofitAPI {
    @GET("b/6978e068ae596e708ffacabc/latest")
    suspend fun getTweets(
        @Header("X-Master-Key") masterKey: String,
        @Header("X-Access-Key") accessKey: String,
        @Header("X-JSON-Path") category: String
    ) : TweetListRecord

    @GET("b/6978e068ae596e708ffacabc/latest")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories(
        @Header("X-Master-Key") masterKey: String,
        @Header("X-Access-Key") accessKey: String
    ) : CategoriesResponse
}