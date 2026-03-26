package com.ablysoft.sampleapp.utils.maputils

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberUpdatedMarkerState

@Composable
fun CustomMap(
    markerLocation: LatLng = LatLng(1.35, 103.87),
    mapProperties: MapProperties = MapProperties(),
    mapUiSettings: MapUiSettings = MapUiSettings(),
    updateAction: () -> Unit = {}
) {
    val markerState = rememberUpdatedMarkerState(position = markerLocation)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(markerLocation, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        properties = mapProperties,
        uiSettings = mapUiSettings,
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = markerState,
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}