package com.nadji.moviecatalogue.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nadji.moviecatalogue.data.source.local.LocalDataSource
import com.nadji.moviecatalogue.data.source.local.entity.MovieEntity
import com.nadji.moviecatalogue.data.source.local.entity.TrailerEntity
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.data.source.remote.RemoteDataSource
import com.nadji.moviecatalogue.ui.utils.PagedListUtil
import com.nadji.moviecatalogue.utils.AppExecutors
import com.nadji.moviecatalogue.utils.DataDummy
import com.nadji.moviecatalogue.utils.LiveDataTestUtil
import com.nadji.moviecatalogue.utils.SortUtils.VOTE_BEST
import com.nadji.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MovieRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutor = mock(AppExecutors::class.java)

    private val movieRepository = FakeMovieRepository(remote, local, appExecutor)

        private val movieResponse = DataDummy.getRemoteMovies()
        private val movieId = movieResponse[0].id
        private val movieDetail = DataDummy.getRemoteDetailMovie()
        private val trailerMovie = DataDummy.getTrailerMovie().key

        private val tvShowResponse = DataDummy.getRemoteTvShow()
        private val tvShowId = tvShowResponse[0].id
        private val tvShowDetail = DataDummy.getRemoteDetailTvShow()
        private val trailerTvShow = DataDummy.getTrailerTv().key

        @Test
        fun getAllMovies() {
            val dataSourceFactory =
                mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
            `when`(local.getAllMovies(VOTE_BEST)).thenReturn(dataSourceFactory)
            movieRepository.getAllMovies(VOTE_BEST)

        val movieEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovies()))
        verify(local).getAllMovies(VOTE_BEST)
        assertNotNull(movieEntity)
        assertEquals(movieResponse.size, movieEntity.data?.size)
    }

    @Test
    fun getDetailMovie() {
        val dummyDetail = MutableLiveData<MovieEntity>()
        dummyDetail.value = DataDummy.getdetailMovie()
        `when`(local.getMovieById(movieId)).thenReturn(dummyDetail)

        val movieDetailEntity = LiveDataTestUtil.getValue(movieRepository.getDetailMovie(movieId))
        verify(local).getMovieById(movieId)
        assertNotNull(movieDetailEntity)
        assertEquals(movieDetail.title, movieDetailEntity.data?.title)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovie()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteMovie()

        val favEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.getMovies()))
        verify(local).getFavoriteMovie()
        assertNotNull(favEntity)
        assertEquals(movieResponse.size, favEntity.data?.size)
    }


    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShow()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTv()

        val favEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getFavoriteTvShow()
        assertNotNull(favEntity)
        assertEquals(tvShowResponse.size, favEntity.data?.size)
    }

    @Test
    fun getTrailerVideo() {
        val dummyTrailer = MutableLiveData<TrailerEntity>()
        dummyTrailer.value = DataDummy.getTrailerMovie()
        `when`(local.getTrailer(movieId)).thenReturn(dummyTrailer)

        val movieTrailerEntity = LiveDataTestUtil.getValue(movieRepository.getTrailerVideo(movieId))
        verify(local).getTrailer(movieId)
        assertNotNull(movieTrailerEntity)
        assertEquals(trailerMovie, movieTrailerEntity.data?.key)
    }


    @Test
    fun getAllTvShow() {
        val dataSourceFactory =
            mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getAllTvShow(VOTE_BEST)).thenReturn(dataSourceFactory)
        movieRepository.getAllTvShow(VOTE_BEST)

        val tvShowEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.getTvShows()))
        verify(local).getAllTvShow(VOTE_BEST)
        assertNotNull(tvShowEntity)
        assertEquals(movieResponse.size, tvShowEntity.data?.size)
    }

    @Test
    fun getDetailTvShow() {
        val dummyDetail = MutableLiveData<TvShowEntity>()
        dummyDetail.value = DataDummy.getdetailTvShow()
        `when`(local.getTvShowById(tvShowId)).thenReturn(dummyDetail)
        val tvShowEntity = LiveDataTestUtil.getValue(movieRepository.getDetailTvShow(tvShowId))
        verify(local).getTvShowById(tvShowId)
        assertNotNull(tvShowEntity)
        assertEquals(tvShowDetail.name, tvShowEntity.data?.name)
    }


    @Test
    fun getTrailerTv() {
        val dummyTrailer = MutableLiveData<TrailerEntity>()
        dummyTrailer.value = DataDummy.getTrailerTv()
        `when`(local.getTrailer(tvShowId)).thenReturn(dummyTrailer)

        val tvTrailerEntity = LiveDataTestUtil.getValue(movieRepository.getTrailerTv(tvShowId))
        verify(local).getTrailer(tvShowId)
        assertNotNull(tvTrailerEntity)
        assertEquals(trailerTvShow, tvTrailerEntity.data?.key)
    }
}