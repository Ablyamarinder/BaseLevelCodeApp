package com.ablysoft.sampleapp.di

import com.ablysoft.sampleapp.utils.dispatcher.DefaultDispatcherProvider
import com.ablysoft.sampleapp.utils.dispatcher.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    fun provideDispatcherProvider(): DispatcherProvider {
        return DefaultDispatcherProvider()
    }

}