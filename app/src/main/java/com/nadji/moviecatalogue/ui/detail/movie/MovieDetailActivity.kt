package com.nadji.moviecatalogue.ui.detail.movie

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.nadji.moviecatalogue.BuildConfig.URL_POSTER_W185
import com.nadji.moviecatalogue.R
import com.nadji.moviecatalogue.data.source.local.entity.MovieEntity
import com.nadji.moviecatalogue.data.source.local.entity.TrailerEntity
import com.nadji.moviecatalogue.databinding.ActivityMovieDetailBinding
import com.nadji.moviecatalogue.viewmodel.ViewModelFactory
import com.nadji.moviecatalogue.vo.Status
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.loadOrCueVideo
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class MovieDetailActivity : AppCompatActivity() {

    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var detailBinding: ActivityMovieDetailBinding
    private lateinit var youtubeKey: String
    private lateinit var movieId: String
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)
        val factory = ViewModelFactory.getInstance(this)
        supportActionBar?.title = "Movie Detail"
        viewModel = ViewModelProvider(this, factory)[MovieDetailViewModel::class.java]

        val extra = intent.extras
        if (extra != null) {
            movieId = extra.getInt(EXTRA_MOVIE).toString()
            viewModel.setSelectedMovieId(movieId)

            viewModel.getTrailerMovie(movieId).observe(
                this,
                { trailer ->
                    when (trailer.status) {
                        Status.LOADING -> detailBinding.detailProgressbar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            if (trailer.data != null) {
                                playTrailer(trailer.data)
                            }
                        }
                        Status.ERROR -> {
                            detailBinding.detailProgressbar.visibility = View.GONE
                            Toast.makeText(this, R.string.error_load_movie, Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                }
            )
        }
    }

    private fun populateMovie(data: MovieEntity) {
        detailBinding.tvTitleDetail.text = data.title
        detailBinding.tvOverview.text = data.overview
        detailBinding.tvRealease.text = data.releaseDate
        detailBinding.tvGenre.text = data.genres

        Glide.with(this@MovieDetailActivity)
            .load(URL_POSTER_W185 + data.posterPath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailBinding.imgPoster)
        detailBinding.detailProgressbar.visibility = View.GONE
    }

    private fun playTrailer(data: TrailerEntity) {
        youtubeKey = data.key

        val youTubePlayerView = YouTubePlayerView(this)
        detailBinding.youtubePlayerView.addView(youTubePlayerView)
        lifecycle.addObserver(youTubePlayerView)
        youTubePlayerView.addYouTubePlayerListener(object :
            AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadOrCueVideo(lifecycle, youtubeKey, 0f)
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.getDetailMovie.observe(this, { movie ->
            if (movie != null) {
                when (movie.status) {
                    Status.LOADING -> detailBinding.detailProgressbar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        if (movie.data != null) {
                            detailBinding.detailProgressbar.visibility = View.GONE
                            val state = movie.data.favorite
                            populateMovie(movie.data)
                            setFavoriteState(state)
                        }
                    }
                    Status.ERROR -> {
                        detailBinding.detailProgressbar.visibility = View.GONE
                        Toast.makeText(this, R.string.error_load_movie, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_border)
        }
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}