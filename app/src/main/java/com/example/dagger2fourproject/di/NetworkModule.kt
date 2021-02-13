package com.example.dagger2fourproject.di

import com.example.dagger2fourproject.network.NetworkService
import com.example.dagger2fourproject.network.model.RetrofitMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient() : OkHttpClient {

        val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .addInterceptor(logger)
            .connectTimeout(15, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()

    }

    @Singleton
    @Provides
    fun provideNetworkRetrofitMapper(): RetrofitMapper {
        return RetrofitMapper()
    }

    @Singleton
    @Provides
    fun provideNetworkService(): NetworkService {
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .client(providesOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(NetworkService::class.java)

    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String {
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}