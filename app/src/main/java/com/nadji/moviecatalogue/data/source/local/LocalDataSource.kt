package com.nadji.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.nadji.moviecatalogue.data.source.local.entity.MovieEntity
import com.nadji.moviecatalogue.data.source.local.entity.TrailerEntity
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.data.source.local.room.MovieDao
import com.nadji.moviecatalogue.utils.SortUtils
import com.nadji.moviecatalogue.utils.SortUtils.MOVIE_ENTITY
import com.nadji.moviecatalogue.utils.SortUtils.TV_SHOW_ENTITY

class LocalDataSource private constructor(private val mMovieDao: MovieDao) {

    fun getAllMovies(sort: String): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies(
        SortUtils.getSortedQuery(sort, MOVIE_ENTITY)
    )

    fun getAllTvShow(sort: String): DataSource.Factory<Int, TvShowEntity> = mMovieDao.getTvShow(
        SortUtils.getSortedQuery(sort, TV_SHOW_ENTITY)
    )

    fun getMovieById(id: Int): LiveData<MovieEntity> = mMovieDao.getMovieById(id)
    fun getTvShowById(id: Int): LiveData<TvShowEntity> = mMovieDao.getTvShowById(id)

    fun getTrailer(id: Int): LiveData<TrailerEntity> = mMovieDao.getTrailer(id)

    fun getFavoriteMovie(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavoriteMovie()
    fun getFavoriteTvShow(): DataSource.Factory<Int, TvShowEntity> = mMovieDao.getFavoriteTvShow()

    fun insertMovie(movie: List<MovieEntity>) = mMovieDao.insertMovies(movie)
    fun insertTvShow(tvShow: List<TvShowEntity>) = mMovieDao.insertTvShows(tvShow)

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        movie.favorite = state
        mMovieDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) {
        tvShow.favorite = state
        mMovieDao.updateTvShow(tvShow)
    }

    fun updateMovie(movie: MovieEntity, state: Boolean) {
        movie.favorite = state
        mMovieDao.updateMovie(movie)
    }

    fun insertTrailer(trailer: TrailerEntity) {
        mMovieDao.insertTrailer(trailer)
    }

    fun updateTvShow(tvShow: TvShowEntity, state: Boolean) {
        tvShow.favorite = state
        mMovieDao.updateTvShow(tvShow)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstace(mMovieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(mMovieDao)
    }
}