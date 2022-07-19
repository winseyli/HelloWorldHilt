package com.example.android.helloworldhilt

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
class FourthModule {

    @Provides
    fun provideInfo(
        @ActivityContext context: Context
    ) : Info {
        return Info(context.getString(R.string.string_in_resource))
    }
}

class Info(val text: String)