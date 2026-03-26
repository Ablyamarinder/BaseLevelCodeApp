package com.ablysoft.sampleapp.utils.networkutil

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ablysoft.core.R
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class NetworkViewModel @Inject constructor(
    connectivityObserver: ConnectivityObserver,
    @ApplicationContext context: Context
) : ViewModel() {

    val initialValue = mutableStateOf(true)
    val networkStatus: StateFlow<ConnectivityObserver.Notify> = connectivityObserver.observe()
        .map {
            val check = it == ConnectivityObserver.Status.Available
            if (check != initialValue.value) {
                initialValue.value = check
                ConnectivityObserver.Notify(
                    true,
                    if (check) context.getString(R.string.internet_reconnected_message) else context.getString(
                        R.string.no_internet_message
                    )
                )
            } else {
                ConnectivityObserver.Notify(false, "")
            }
        } // Map to a simple Boolean for UI
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = ConnectivityObserver.Notify(false, "")// Assume online initially
        )

    val isConnected = connectivityObserver.isConnected
}