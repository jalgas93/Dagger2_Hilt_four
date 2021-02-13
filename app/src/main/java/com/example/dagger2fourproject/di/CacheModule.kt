package com.example.dagger2fourproject.di

import androidx.room.Room
import com.example.dagger2fourproject.cache.RoomServiceDao
import com.example.dagger2fourproject.cache.database.AppDatabase
import com.example.dagger2fourproject.cache.roomMapper.RoomMapper
import com.example.dagger2fourproject.presentation.BaseApplication
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {
    @Singleton
    @Provides
    fun provideDb(app: BaseApplication): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideRecipeDao(db: AppDatabase): RoomServiceDao {
        return db.roomServiceDao()
    }

    @Singleton
    @Provides
    fun provideRoomMapper(): RoomMapper {
        return RoomMapper()
    }
}