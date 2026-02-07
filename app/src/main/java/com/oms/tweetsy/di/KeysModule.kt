package com.oms.tweetsy.di

import com.oms.tweetsy.di.qualifiers.AccessKey
import com.oms.tweetsy.di.qualifiers.MasterKey
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.oms.tweetsy.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
class KeysModule {
    @Provides
    @MasterKey
    fun provideMasterKey(): String = BuildConfig.MASTER_KEY

    @Provides
    @AccessKey
    fun provideAccessKey(): String = BuildConfig.ACCESS_KEY
}