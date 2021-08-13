package com.nadji.moviecatalogue.ui.favorite.movie

import androidx.lifecycle.ViewModel
import com.nadji.moviecatalogue.data.MovieRepository

class FavoriteMovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getFavMovie() = movieRepository.getFavoriteMovie()
}