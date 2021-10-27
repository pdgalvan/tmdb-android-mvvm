package com.example.tmdb.di

import com.example.tmdb.data.remote.TmdbService
import com.example.tmdb.data.repository.TmdbRepositoryImpl
import com.example.tmdb.domain.repository.TmdbRepository
import com.example.tmdb.util.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi() : Moshi =
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun provideTmdbService(moshiConverterFactory: MoshiConverterFactory) : TmdbService{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
            .create(TmdbService::class.java)
    }

    @Provides
    @Singleton
    fun provideTmdbRepository(service: TmdbService): TmdbRepository{
        return TmdbRepositoryImpl(service)
    }
}
