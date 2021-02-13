package com.example.dagger2fourproject.di

import com.example.dagger2fourproject.network.NetworkService
import com.example.dagger2fourproject.network.model.RetrofitMapper
import com.example.dagger2fourproject.network.model.RetrofitModel
import com.example.dagger2fourproject.repository.ReposImpl
import com.example.dagger2fourproject.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton
@InstallIn(ApplicationComponent::class)
@Module

abstract class RepositoryModule {


    @Binds
   abstract fun providesRepository(

reposImpl: ReposImpl
    ):Repository


}