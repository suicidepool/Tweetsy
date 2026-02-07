package com.oms.tweetsy.di

import androidx.compose.runtime.mutableStateOf
import com.oms.tweetsy.api.RetrofitAPI
import com.oms.tweetsy.di.qualifiers.AccessKey
import com.oms.tweetsy.di.qualifiers.MasterKey
import com.oms.tweetsy.repository.TweetsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideTweetsRepository(
        retrofitAPI: RetrofitAPI,
        @MasterKey masterKey: String,
        @AccessKey accessKey: String
        ) : TweetsRepository{
        return TweetsRepository(
            retrofitAPI = retrofitAPI,
            masterKey = masterKey,
            accessKey= accessKey,
        )
    }
}