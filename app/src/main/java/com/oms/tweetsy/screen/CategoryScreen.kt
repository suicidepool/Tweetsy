package com.oms.tweetsy.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.oms.tweetsy.viewmodel.CategoryViewModel

@Composable
fun CategoryScreen(modifier: Modifier = Modifier) {

    val categoryViewModel: CategoryViewModel = viewModel()
    val categories = categoryViewModel.categories

    LazyVerticalGrid(
        modifier = modifier
            .statusBarsPadding(),
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        items(categories){
            CategoryItem(
                category = it,
                onClick = {
                    Log.d("TAG", it)
                }
            )
        }
    }
    
}


@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .padding(4.dp)
            .size(160.dp)
            .clip(RoundedCornerShape(8.dp))
            .border(2.dp, Color(0xFF4B4B4B), shape = RoundedCornerShape(8.dp))
            .background(color = Color(0xFFD7D7D7), shape = RoundedCornerShape(8.dp))
            .clickable{
                onClick()
            },
        contentAlignment = Alignment.BottomCenter
    ){
        Text(
            text = category,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(0.dp,20.dp)
        )
    }
}