package com.nadji.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.nadji.moviecatalogue.data.MovieRepository

class TvShowViewModel(private val tvShowRepository: MovieRepository) : ViewModel() {
    fun getTvShow(sort: String) = tvShowRepository.getAllTvShow(sort)
}