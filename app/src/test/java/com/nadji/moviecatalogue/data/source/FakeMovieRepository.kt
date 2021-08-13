package com.nadji.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.nadji.moviecatalogue.data.MovieDataSource
import com.nadji.moviecatalogue.data.NetworkBoundResource
import com.nadji.moviecatalogue.data.source.local.LocalDataSource
import com.nadji.moviecatalogue.data.source.local.entity.MovieEntity
import com.nadji.moviecatalogue.data.source.local.entity.TrailerEntity
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.data.source.remote.ApiResponse
import com.nadji.moviecatalogue.data.source.remote.RemoteDataSource
import com.nadji.moviecatalogue.data.source.remote.ResultsItem
import com.nadji.moviecatalogue.data.source.remote.response.*
import com.nadji.moviecatalogue.utils.AppExecutors
import com.nadji.moviecatalogue.vo.Resource

class FakeMovieRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
) : MovieDataSource {
    override fun getAllMovies(sort: String): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<ResultsItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(8)
                    .setPageSize(8)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllMovies(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsItem>>> =
                remoteDataSource.getAllMovies()

            override fun saveCallResult(data: List<ResultsItem>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        id = response.id,
                        title = response.title,
                        releaseDate = response.release_date,
                        posterPath = response.posterPath,
                        vote_average = response.vote_average,
                        favorite = false,
                        overview = response.overview,
                        genres = ""
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovie(id: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getMovieById(id)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data != null && data.genres == ""

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getMovieDetail(id.toString())

            override fun saveCallResult(data: MovieDetailResponse) {
                val genresItem = StringBuilder().append("")
                for (genre in data.genres.indices) {
                    if (genre < data.genres.size - 1) {
                        genresItem.append("${data.genres[genre].name}, ")
                    } else {
                        genresItem.append(data.genres[genre].name)
                    }
                }

                val movies = MovieEntity(
                    id,
                    title = data.title,
                    posterPath = data.posterPath,
                    releaseDate = data.release_date,
                    overview = data.overview,
                    vote_average = data.vote_average,
                    favorite = false,
                    genres = genresItem.toString()
                )
                localDataSource.updateMovie(movies, false)
            }
        }.asLiveData()
    }

    override fun getAllTvShow(sort: String): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<ResultsTvItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(8)
                    .setPageSize(8)
                    .build()
                return LivePagedListBuilder(localDataSource.getAllTvShow(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<ResultsTvItem>>> =
                remoteDataSource.getAllTvShow()

            override fun saveCallResult(data: List<ResultsTvItem>) {
                val tvShowList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val tvShow = TvShowEntity(
                        id = response.id,
                        name = response.name,
                        posterPath = response.posterPath,
                        releaseDate = response.first_air_date,
                        overview = response.overview,
                        vote_average = response.vote_average,
                        favorite = false,
                        genres = ""
                    )
                    tvShowList.add(tvShow)
                }
                localDataSource.insertTvShow(tvShowList)
            }

        }.asLiveData()
    }

    override fun getDetailTvShow(id: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvDetailResponse>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowById(id)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data != null && data.genres == ""

            override fun createCall(): LiveData<ApiResponse<TvDetailResponse>> =
                remoteDataSource.getTvShowDetail(id.toString())

            override fun saveCallResult(data: TvDetailResponse) {
                val genresItem = StringBuilder().append("")
                for (genre in data.genres.indices) {
                    if (genre < data.genres.size - 1) {
                        genresItem.append("${data.genres[genre].name}, ")
                    } else {
                        genresItem.append(data.genres[genre].name)
                    }
                }

                val tvShow = TvShowEntity(
                    id,
                    name = data.name,
                    posterPath = data.posterPath,
                    releaseDate = data.firstAirDate,
                    vote_average = data.vote_average,
                    favorite = false,
                    genres = genresItem.toString(),
                    overview = data.overview
                )
                localDataSource.updateTvShow(tvShow, false)
            }

        }.asLiveData()
    }


    override fun getTrailerVideo(movieId: Int): LiveData<Resource<TrailerEntity>> {
        return object : NetworkBoundResource<TrailerEntity, ResponseMovieTrailer>(appExecutors) {
            override fun loadFromDB(): LiveData<TrailerEntity> =
                localDataSource.getTrailer(movieId)

            override fun shouldFetch(data: TrailerEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<ResponseMovieTrailer>> =
                remoteDataSource.getTrailerMovie(movieId)

            override fun saveCallResult(data: ResponseMovieTrailer) {
                val mKey = data.results[0].key
                val trailer = TrailerEntity(movieId, key = mKey)
                localDataSource.insertTrailer(trailer)
            }
        }.asLiveData()
    }

    override fun getTrailerTv(tvId: Int): LiveData<Resource<TrailerEntity>> {
        return object : NetworkBoundResource<TrailerEntity, ResponseTvTrailer>(appExecutors) {
            override fun loadFromDB(): LiveData<TrailerEntity> =
                localDataSource.getTrailer(tvId)

            override fun shouldFetch(data: TrailerEntity?): Boolean =
                data == null

            override fun createCall(): LiveData<ApiResponse<ResponseTvTrailer>> =
                remoteDataSource.getTrailerTv(tvId)

            override fun saveCallResult(data: ResponseTvTrailer) {
                val mKey = data.results[0].key
                val trailer = TrailerEntity(tvId, key = mKey)
                localDataSource.insertTrailer(trailer)
            }

        }.asLiveData()
    }

    override fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovie(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }
    }

    override fun getFavoriteTv(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShow(), config).build()
    }

    override fun setFavoriteTv(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }
    }
}