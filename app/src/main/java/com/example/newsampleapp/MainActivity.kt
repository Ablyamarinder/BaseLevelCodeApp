package com.example.newsampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.newsampleapp.ui.navigation.MyAppNavController
import com.example.newsampleapp.ui.posts.PostViewModel
import com.example.newsampleapp.ui.theme.NewSampleAppTheme
import com.example.newsampleapp.utils.networkutil.NetworkViewModel
import com.example.newsampleapp.utils.toastutils.ToastUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: PostViewModel by viewModels()
    private val networkViewModel: NetworkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val networkStatus = networkViewModel.networkStatus.collectAsState()

            NewSampleAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(color = MaterialTheme.colorScheme.tertiary),
                        contentAlignment = Alignment.Center
                    ) {
                        MyAppNavController()
                        if (networkStatus.value.not()) {
                            ToastUtils.showLongToast(
                                this@MainActivity,
                                this@MainActivity.getString(R.string.no_internet_message)
                            )
                        }

                    }
                }
            }
        }
    }
}
