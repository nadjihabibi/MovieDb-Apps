package com.nadji.moviecatalogue.data


import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.nadji.moviecatalogue.data.source.local.entity.MovieEntity
import com.nadji.moviecatalogue.data.source.local.entity.TrailerEntity
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.vo.Resource

interface MovieDataSource {
    fun getAllMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>>
    fun getDetailMovie(id: Int): LiveData<Resource<MovieEntity>>

    fun getAllTvShow(sort: String): LiveData<Resource<PagedList<TvShowEntity>>>
    fun getDetailTvShow(id: Int): LiveData<Resource<TvShowEntity>>

    fun getTrailerVideo(movieId: Int): LiveData<Resource<TrailerEntity>>
    fun getTrailerTv(tvId: Int): LiveData<Resource<TrailerEntity>>

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>>
    fun setFavoriteMovie(movie: MovieEntity, state: Boolean)

    fun getFavoriteTv(): LiveData<PagedList<TvShowEntity>>
    fun setFavoriteTv(tvShow: TvShowEntity, state: Boolean)
}