package com.ablysoft.sampleapp

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
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
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import com.ablysoft.core.designsystem.component.CustomBackground
import com.ablysoft.core.designsystem.theme.CustomAppTheme
import com.ablysoft.sampleapp.utils.networkutil.NetworkViewModel
import com.ablysoft.sampleapp.utils.toastutils.ToastUtils
import com.ablysoft.sampleapp.utils.uiutils.bottomnav.BottomNavComposable
import com.ablysoft.sampleapp.utils.uiutils.navigation.MyAppNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val networkViewModel: NetworkViewModel by viewModels()
    private var keepSplashScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        // Keep the splash screen on-screen with a delay of 5 seconds. This condition is
        // evaluated each time the app needs to be redrawn so it should be fast to avoid blocking
        // the UI.
        splashScreen.setOnExitAnimationListener { splashScreenView ->
            // Create your custom animation.
            val slideUp = ObjectAnimator.ofFloat(
                splashScreenView.view,
                View.TRANSLATION_X,
                0f,
                -splashScreenView.view.height.toFloat()
            )
            slideUp.interpolator = AnticipateInterpolator()
            slideUp.duration = 200L

            // Call SplashScreenView.remove at the end of your custom animation.
            slideUp.doOnEnd { splashScreenView.remove() }

            // Run your animation.
            slideUp.start()
        }
        splashScreen.setKeepOnScreenCondition { keepSplashScreen }
        enableEdgeToEdge()
        lifecycleScope.launch {
            delay(5000)
            keepSplashScreen = false
        }

        setContent {
            val navController = rememberNavController()
            val networkStatus = networkViewModel.networkStatus.collectAsState()
            CustomAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavComposable {
                            navController.navigate(route = it)
                        }
                    }

                ) { innerPadding ->
                    CustomBackground {
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                                .background(color = MaterialTheme.colorScheme.tertiary),
                            contentAlignment = Alignment.Center
                        ) {
                            MyAppNavController(navController)
                            if (networkStatus.value.showToast) {
                                ToastUtils.showLongToast(
                                    this@MainActivity,
                                    networkStatus.value.message
                                )
                            }

                        }
                    }
                }
            }
        }
    }
}