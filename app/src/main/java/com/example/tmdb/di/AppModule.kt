package com.example.tmdb.di

import com.example.tmdb.data.remote.TmdbApi
import com.example.tmdb.data.repository.TmdbRepositoryImpl
import com.example.tmdb.domain.repository.TmdbRepository
import com.example.tmdb.util.Constants.BASE_URL
import com.squareup.moshi.Moshi
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
        Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory =
        MoshiConverterFactory.create(moshi)

    @Provides
    @Singleton
    fun provideTmdbApi(moshiConverterFactory: MoshiConverterFactory) : TmdbApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
            .create(TmdbApi::class.java)
    }

    @Provides
    @Singleton
    fun provideTmdbRepository(api: TmdbApi): TmdbRepository{
        return TmdbRepositoryImpl(api)
    }
}
