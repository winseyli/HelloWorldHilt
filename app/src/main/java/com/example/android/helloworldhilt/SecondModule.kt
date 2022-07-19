package com.example.android.helloworldhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

// @InstallIn to tell Hilt which Android class each module will be used or installed in
@Module
@InstallIn(ActivityComponent::class)
class SecondModule {

    // The @Provides annotation tells Hilt which implementation to use when it needs to
    // provide an instance of the type.
    @Provides
    open fun provideExternalLibraryService(
        // Potential dependencies of this type
    ): ExternalLibraryService {
        return ExternalLibraryService()
    }
}

// Pretends as a service from external library
class ExternalLibraryService {

    fun generateMessage() : String {
        // Assume this is something from external library
        return "Hello World this is a text from a class pretending as an external class"
    }
}