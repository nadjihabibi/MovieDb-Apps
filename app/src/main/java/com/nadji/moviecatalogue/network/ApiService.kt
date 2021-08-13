package com.nadji.moviecatalogue.network

import com.nadji.moviecatalogue.data.source.remote.MovieResponse
import com.nadji.moviecatalogue.data.source.remote.response.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getMovie(
        @Query("api_key") apiKey: String,
    ): Call<MovieResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: String,
        @Query("api_key") apiKey: String,
    ): Call<MovieDetailResponse>

    @GET("discover/tv")
    fun getTvShow(
        @Query("api_key") apiKey: String,
    ): Call<TvShowResponse>

    @GET("tv/{id}")
    fun getTvShowDetail(
        @Path("id") id: String,
        @Query("api_key") apiKey: String,
    ): Call<TvDetailResponse>

    @GET("movie/{id}/videos")
    fun getMovieTrailer(
        @Path("id") id: String,
        @Query("api_key") apiKey: String,
    ): Call<ResponseMovieTrailer>

    @GET("tv/{id}/videos")
    fun getTvTrailer(
        @Path("id") id: String,
        @Query("api_key") apiKey: String,
    ): Call<ResponseTvTrailer>
}