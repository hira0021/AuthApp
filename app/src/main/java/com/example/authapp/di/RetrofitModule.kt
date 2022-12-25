package com.example.authapp.di

import com.example.authapp.data.remote.TodoApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder() : Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideOkhttpLoggingInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okhttp: OkHttpClient) : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okhttp)
    }

    @Singleton
    @Provides
    fun provideTodoService(retrofit: Retrofit.Builder): TodoApi {
        return retrofit
            .build()
            .create(TodoApi::class.java)
    }


}