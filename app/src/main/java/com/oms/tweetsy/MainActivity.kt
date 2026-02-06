package com.oms.tweetsy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.oms.tweetsy.api.RetrofitAPI
import com.oms.tweetsy.ui.screen.HomeScreen
import com.oms.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var retrofitAPI: RetrofitAPI

    private val masterKey = "\$2a\$10\$67l6xa1BNc8CBZkLwr4p6.FMXBpeQahMlfQ.h55CsAbjHdRraFs1."
    private val accessKey = "\$2a\$10\$cSsxwp0TrehmRy.tYw8LdOP6Qt47xOmcSs6wuaBVbubSj6tWw0CXG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            val categories = retrofitAPI.getCategories(
                masterKey = masterKey,
                accessKey = accessKey
            ).record.distinct()
            Log.d("TAG",categories.toString())
        }
        setContent {
            TweetsyTheme {
                Text(text = "hiii", fontSize = 55.sp)
//                HomeScreen(
//                    retrofitAPI = retrofitAPI
//                )
            }
        }
    }
}
