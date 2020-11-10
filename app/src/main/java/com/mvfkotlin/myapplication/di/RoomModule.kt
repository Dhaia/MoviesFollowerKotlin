package com.mvfkotlin.myapplication.di

import android.content.Context
import androidx.room.Room
import com.mvfkotlin.myapplication.database.DbDao
import com.mvfkotlin.myapplication.database.ItemsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideItemsDb(@ApplicationContext context: Context): ItemsDatabase{
        return Room.databaseBuilder(
            context,
            ItemsDatabase::class.java,
            ItemsDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDbDao(itemsDatabase: ItemsDatabase): DbDao {
        return itemsDatabase.databaseDao()
    }
}