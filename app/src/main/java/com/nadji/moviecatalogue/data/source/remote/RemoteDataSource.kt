package com.nadji.moviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nadji.moviecatalogue.BuildConfig.API_KEY
import com.nadji.moviecatalogue.data.source.remote.response.*
import com.nadji.moviecatalogue.network.ApiConfig
import com.nadji.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null
        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getAllMovies(): LiveData<ApiResponse<List<ResultsItem>>> {
        EspressoIdlingResource.increment()
        val movieResult = MutableLiveData<ApiResponse<List<ResultsItem>>>()
        val client = ApiConfig.getApiService().getMovie(API_KEY)

        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movieResult.value =
                    ApiResponse.success(response.body()?.results as List<ResultsItem>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: getAllMovies")
                EspressoIdlingResource.decrement()
            }
        })
        return movieResult
    }

    fun getMovieDetail(movieId: String): LiveData<ApiResponse<MovieDetailResponse>> {
        EspressoIdlingResource.increment()
        val movieDetailResult = MutableLiveData<ApiResponse<MovieDetailResponse>>()
        val client = ApiConfig.getApiService().getMovieDetail(movieId, API_KEY)

        client.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>,
            ) {
                movieDetailResult.value =
                    ApiResponse.success(response.body() as MovieDetailResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: getMovieDetail")
                EspressoIdlingResource.decrement()
            }
        })
        return movieDetailResult
    }

    fun getAllTvShow(): LiveData<ApiResponse<List<ResultsTvItem>>> {
        EspressoIdlingResource.increment()
        val tvResult = MutableLiveData<ApiResponse<List<ResultsTvItem>>>()
        val client = ApiConfig.getApiService().getTvShow(API_KEY)

        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>,
            ) {
                tvResult.value =
                    ApiResponse.success(response.body()?.results as List<ResultsTvItem>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: getAllTvShow")
                EspressoIdlingResource.decrement()
            }
        })
        return tvResult
    }

    fun getTvShowDetail(tvShowId: String): LiveData<ApiResponse<TvDetailResponse>> {
        EspressoIdlingResource.increment()
        val tvDetailResponse = MutableLiveData<ApiResponse<TvDetailResponse>>()
        val client = ApiConfig.getApiService().getTvShowDetail(tvShowId, API_KEY)
        client.enqueue(object : Callback<TvDetailResponse> {
            override fun onResponse(
                call: Call<TvDetailResponse>,
                response: Response<TvDetailResponse>,
            ) {
                tvDetailResponse.value = ApiResponse.success(response.body() as TvDetailResponse)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: getTvShowDetail")
                EspressoIdlingResource.decrement()
            }

        })
        return tvDetailResponse
    }

    fun getTrailerMovie(movieId: Int): LiveData<ApiResponse<ResponseMovieTrailer>> {
        EspressoIdlingResource.increment()
        val movieTrailer = MutableLiveData<ApiResponse<ResponseMovieTrailer>>()
        val client = ApiConfig.getApiService().getMovieTrailer(movieId.toString(), API_KEY)
        client.enqueue(object : Callback<ResponseMovieTrailer> {
            override fun onResponse(
                call: Call<ResponseMovieTrailer>,
                response: Response<ResponseMovieTrailer>,
            ) {
                movieTrailer.value = ApiResponse.success(response.body() as ResponseMovieTrailer)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ResponseMovieTrailer>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: getTrailerMovie")
                EspressoIdlingResource.decrement()
            }

        })
        return movieTrailer

    }

    fun getTrailerTv(tvShowId: Int): LiveData<ApiResponse<ResponseTvTrailer>> {
        EspressoIdlingResource.increment()
        val tvTrailer = MutableLiveData<ApiResponse<ResponseTvTrailer>>()
        val client = ApiConfig.getApiService().getTvTrailer(tvShowId.toString(), API_KEY)
        client.enqueue(object : Callback<ResponseTvTrailer> {
            override fun onResponse(
                call: Call<ResponseTvTrailer>,
                response: Response<ResponseTvTrailer>,
            ) {
                tvTrailer.value = ApiResponse.success(response.body() as ResponseTvTrailer)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<ResponseTvTrailer>, t: Throwable) {
                Log.e("RemoteDataSource", "onFailure: getTrailerTv")
                EspressoIdlingResource.decrement()
            }
        })
        return tvTrailer
    }
}
