package com.nadji.moviecatalogue.ui.detail.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nadji.moviecatalogue.data.MovieRepository
import com.nadji.moviecatalogue.data.source.local.entity.MovieEntity
import com.nadji.moviecatalogue.data.source.local.entity.TrailerEntity
import com.nadji.moviecatalogue.vo.Resource

class MovieDetailViewModel(private val repository: MovieRepository) : ViewModel() {
    val movieId = MutableLiveData<String>()

    fun setSelectedMovieId(movieId: String) {
        this.movieId.value = movieId
    }

    var getDetailMovie: LiveData<Resource<MovieEntity>> =
        Transformations.switchMap(movieId) { mMovieId ->
            repository.getDetailMovie(mMovieId.toInt())
        }

    fun getTrailerMovie(id: String): LiveData<Resource<TrailerEntity>> =
        repository.getTrailerVideo(id.toInt())


    fun setFavorite() {
        val resource = getDetailMovie.value
        if (resource?.data != null) {
            val newState = !resource.data.favorite
            repository.setFavoriteMovie(resource.data, newState)
        }
    }
}