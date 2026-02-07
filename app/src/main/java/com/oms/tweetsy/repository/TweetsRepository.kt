package com.oms.tweetsy.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.oms.tweetsy.api.RetrofitAPI
import com.oms.tweetsy.model.Tweet
import javax.inject.Inject

class TweetsRepository (
    private val retrofitAPI: RetrofitAPI,
    private val masterKey: String,
    private val accessKey: String,
) {

    suspend fun getCategories() : List<String>{
        var categories: List<String> = emptyList()
        try {
            categories = retrofitAPI.getCategories(
                masterKey = masterKey,
                accessKey = accessKey
            ).record.distinct()
        } catch (e: Exception){
            e.printStackTrace()
        }
        return categories
    }

    suspend fun getTweets(category: String) : List<Tweet> {
        var tweets: List<Tweet> = emptyList()
        try {
            tweets = retrofitAPI.getTweets(
                masterKey = masterKey,
                accessKey = accessKey,
                category = category
            ).record.tweets
        } catch (e: Exception){
            e.printStackTrace()
        }
        return tweets
    }
}