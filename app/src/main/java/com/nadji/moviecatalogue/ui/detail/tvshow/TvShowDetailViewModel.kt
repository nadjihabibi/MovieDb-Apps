package com.nadji.moviecatalogue.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nadji.moviecatalogue.data.MovieRepository
import com.nadji.moviecatalogue.data.source.local.entity.TrailerEntity
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.vo.Resource

class TvShowDetailViewModel(private val repository: MovieRepository) : ViewModel() {
    val tvShowId = MutableLiveData<String>()

    fun setSelectedTvShowId(tvShowId: String) {
        this.tvShowId.value = tvShowId
    }

    var getDetailTvShow: LiveData<Resource<TvShowEntity>> =
        Transformations.switchMap(tvShowId) { mTvId ->
            repository.getDetailTvShow(mTvId.toInt())
        }

    fun getTrailerTvId(id: String): LiveData<Resource<TrailerEntity>> =
        repository.getTrailerTv(id.toInt())

    fun setFavorite() {
        val resource = getDetailTvShow.value
        if (resource?.data != null) {
            val newState = !resource.data.favorite
            repository.setFavoriteTv(resource.data, newState)
        }
    }
}