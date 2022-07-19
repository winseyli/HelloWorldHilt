package com.example.android.helloworldhilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TypeAClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TypeBClient

// @InstallIn to tell Hilt which Android class each module will be used or installed in
@Module
@InstallIn(ActivityComponent::class)
class ThirdModule {

    @Provides
    fun provideMessageService(
        // @TypeBClient as a dependency
        @TypeBClient client: Client
    ): MessageService {
        return MessageService(client)
    }

    @TypeAClient
    @Provides
    fun provideTypeAClient(): Client {
        return Client("Client Type A")
    }

    @TypeBClient
    @Provides
    fun provideTypeBClient(): Client {
        return Client("Client Type B")
    }
}

class MessageService(
    private val client: Client
) {
    fun generateMessage(): String {
        return "Hello this is a message generated from ${client.name}"
    }
}

class Client(val name: String) {
    fun generateMessage(): String {
        return "Hello this is a message generated from $name"
    }
}
