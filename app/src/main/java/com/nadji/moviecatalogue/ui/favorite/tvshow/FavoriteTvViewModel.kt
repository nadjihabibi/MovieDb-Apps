package com.nadji.moviecatalogue.ui.favorite.tvshow

import androidx.lifecycle.ViewModel
import com.nadji.moviecatalogue.data.MovieRepository

class FavoriteTvViewModel(private val movieRepository: MovieRepository) : ViewModel() {
    fun getFavTv() = movieRepository.getFavoriteTv()
}