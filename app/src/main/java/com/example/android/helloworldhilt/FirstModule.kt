package com.example.android.helloworldhilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject

// @InstallIn to tell Hilt which Android class each module will be used or installed in
@Module
@InstallIn(ActivityComponent::class)
abstract class FirstModule {

    // The @Binds annotation tells Hilt which implementation to use when it needs to
    // provide an instance of an interface.
    @Binds
    abstract fun bindLocalService(
        localServiceImpl: LocalServiceImpl
    ): LocalService
}

interface LocalService {
    fun generateMessage() : String
}

// Constructor-injected, because Hilt needs to know how to
// provide instances of LocalServiceImpl
class LocalServiceImpl @Inject constructor() : LocalService {

    override fun generateMessage() : String {
        return "Hello this is a message generated from LocalService"
    }
}