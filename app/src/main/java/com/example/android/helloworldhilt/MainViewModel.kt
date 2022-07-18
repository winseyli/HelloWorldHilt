package com.example.android.helloworldhilt

import javax.inject.Inject

// Use constructor injection to define Hilt bindings
class MainViewModel @Inject constructor() {
    val text = "Hello World Hilt"
}