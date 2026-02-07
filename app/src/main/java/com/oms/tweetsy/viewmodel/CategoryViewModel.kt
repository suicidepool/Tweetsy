package com.oms.tweetsy.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oms.tweetsy.model.Tweet
import com.oms.tweetsy.repository.TweetsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    val tweetsyRepository: TweetsRepository
) : ViewModel() {
    var categories by mutableStateOf(emptyList<String>())

    init {
        viewModelScope.launch {
            categories = tweetsyRepository.getCategories()
        }
    }
}