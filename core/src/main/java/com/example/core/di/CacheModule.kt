package com.example.core.di

import android.content.Context
import com.example.core.data.cache.AppDatabase
import com.example.core.data.cache.CorePrefsImpl
import com.example.core.domain.CorePrefs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(
            context
        )
    }

    @Provides
    @Singleton
    fun provideScoresDao(db: AppDatabase) = db.scoresDao


    @Singleton
    @Provides
    fun provideSharedPrefs(@ApplicationContext context: Context): CorePrefs {
        return CorePrefsImpl(context)
    }
}