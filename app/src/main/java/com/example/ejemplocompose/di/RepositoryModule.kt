package com.example.ejemplocompose.di

import com.example.ejemplocompose.datasource.RestDataSource
import com.example.ejemplocompose.repository.UserRepository
import com.example.ejemplocompose.repository.UserRepositoryImp
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun userRepository(repo: UserRepositoryImp): UserRepository

}