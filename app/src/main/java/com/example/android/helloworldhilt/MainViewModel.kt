package com.example.android.helloworldhilt

import javax.inject.Inject

// Use constructor injection to define Hilt bindings
class MainViewModel @Inject constructor(
    private val service: LocalService
) {
    val text = "Hello World Hilt"

    fun getMessage() : String {
        return service.generateMessage()
    }
}