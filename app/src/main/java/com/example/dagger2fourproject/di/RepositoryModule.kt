package com.example.dagger2fourproject.di

import com.example.dagger2fourproject.network.NetworkService
import com.example.dagger2fourproject.network.model.RetrofitMapper
import com.example.dagger2fourproject.network.model.RetrofitModel
import com.example.dagger2fourproject.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {


    @Singleton
    @Provides
    fun providesRepository(
retrofitMapper: RetrofitMapper,
networkService: NetworkService
    ):Repository{
        return Repository(networkService, retrofitMapper)
    }


}