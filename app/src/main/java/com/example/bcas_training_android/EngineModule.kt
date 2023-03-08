package com.example.bcas_training_android

import com.example.bcas_training_android.model.Engine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object EngineModule {
    @Singleton
    @Provides
    fun providedEngine() : Engine{
        return Engine()
    }
}