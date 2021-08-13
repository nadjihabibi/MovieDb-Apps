package com.nadji.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.nadji.moviecatalogue.data.MovieRepository

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getMovies(sort: String) = movieRepository.getAllMovies(sort)
}