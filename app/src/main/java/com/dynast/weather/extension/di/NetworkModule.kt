package com.dynast.weather.extension.di

import com.dynast.weather.data.api.WeatherApiService
import com.dynast.weather.data.api.YoutubeApiService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val ConnectTimeOut = 10L
    private const val WriteTimeOut = 1L
    private const val ReadTimeOut = 20L

    private const val weatherUrl = "https://api.open-meteo.com/"
    private const val youtubeUrl = "https://www.googleapis.com/youtube/"

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            connectTimeout(ConnectTimeOut, TimeUnit.SECONDS)
            writeTimeout(WriteTimeOut, TimeUnit.SECONDS)
            readTimeout(ReadTimeOut, TimeUnit.SECONDS)
            retryOnConnectionFailure(true)
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(okHttpClient: OkHttpClient): WeatherApiService {
        val gson = GsonBuilder().serializeNulls().setLenient().create()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(weatherUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideYoutubeApiService(okHttpClient: OkHttpClient): YoutubeApiService {
        val gson = GsonBuilder().serializeNulls().setLenient().create()
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(youtubeUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build().create(YoutubeApiService::class.java)
    }
}