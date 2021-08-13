package com.nadji.moviecatalogue.di

import android.content.Context
import com.nadji.moviecatalogue.data.MovieRepository
import com.nadji.moviecatalogue.data.source.local.LocalDataSource
import com.nadji.moviecatalogue.data.source.local.room.MovieDatabase
import com.nadji.moviecatalogue.data.source.remote.RemoteDataSource
import com.nadji.moviecatalogue.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): MovieRepository {
        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()

        val localDataSource = LocalDataSource.getInstace(database.movieDao())

        val appExecutors = AppExecutors()

        return MovieRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}