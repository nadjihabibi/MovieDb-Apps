package com.nadji.moviecatalogue.ui.detail.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nadji.moviecatalogue.data.MovieRepository
import com.nadji.moviecatalogue.data.source.local.entity.MovieEntity
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.ui.detail.movie.MovieDetailViewModel
import com.nadji.moviecatalogue.utils.DataDummy
import com.nadji.moviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.http.GET

@RunWith(MockitoJUnitRunner::class)
class TvShowDetailViewModelTest {

    private lateinit var viewModel: TvShowDetailViewModel
    private val dummyTv = DataDummy.getdetailTvShow()
    private val tvShowId = dummyTv.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tvSowRepository: MovieRepository

    @Mock
    private lateinit var tvObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowDetailViewModel(tvSowRepository)
        viewModel.setSelectedTvShowId(tvShowId)
    }

    @Test
    fun getDetailTvShow() {
        val expected = MutableLiveData<Resource<TvShowEntity>>()
        expected.value = Resource.success(DataDummy.getdetailTvShow())
        `when`(tvSowRepository.getDetailTvShow(tvShowId.toInt())).thenReturn(expected)
        viewModel.getDetailTvShow.observeForever(tvObserver)

        verify(tvObserver).onChanged(expected.value)

        val expectedValue = expected.value
        val actualValue = viewModel.getDetailTvShow.value
        TestCase.assertNotNull(expectedValue)
        TestCase.assertNotNull(actualValue)
        assertEquals(expectedValue, actualValue)
    }

}