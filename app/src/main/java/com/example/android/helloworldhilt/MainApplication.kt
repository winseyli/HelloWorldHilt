package com.example.android.helloworldhilt

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// @HiltAndroidApp generated Hilt component is attached to the Application object's lifecycle
// and provides dependencies to it.
@HiltAndroidApp
class MainApplication : Application() {
}