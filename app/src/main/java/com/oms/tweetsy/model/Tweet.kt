package com.oms.tweetsy.model

import com.google.gson.annotations.SerializedName

data class Tweet(
    @SerializedName("text")
    val text: String = "",

    @SerializedName("category")
    val category: String = ""
)