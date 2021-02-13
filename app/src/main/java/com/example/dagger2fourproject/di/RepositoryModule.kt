package com.example.dagger2fourproject.di

import com.example.dagger2fourproject.cache.RoomServiceDao
import com.example.dagger2fourproject.cache.roomMapper.RoomMapper
import com.example.dagger2fourproject.network.NetworkService
import com.example.dagger2fourproject.network.model.RetrofitMapper
import com.example.dagger2fourproject.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)

 object RepositoryModule {


    //@Binds
    @Singleton
    @Provides
    fun providesRepository(
retrofitMapper: RetrofitMapper,
        networkService: NetworkService,
        roomServiceDao: RoomServiceDao,
        roomMapper: RoomMapper
//reposImpl: ReposImpl
    ):Repository{
        return Repository(networkService, retrofitMapper,roomServiceDao, roomMapper)
    }


}