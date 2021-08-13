package com.nadji.moviecatalogue.ui.favorite.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nadji.moviecatalogue.BuildConfig
import com.nadji.moviecatalogue.R
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.databinding.ItemMovieBinding
import com.nadji.moviecatalogue.ui.detail.tvshow.TvShowDetailActivity

class FavoriteTvAdapter :
    PagedListAdapter<TvShowEntity, FavoriteTvAdapter.FavoriteVieHolder>(DIFF_CALLBACK) {

    class FavoriteVieHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvShowEntity) {
            with(binding) {
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, TvShowDetailActivity::class.java)
                    intent.putExtra(TvShowDetailActivity.EXTRA_TVSHOW, tvShows.id)
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context).load(BuildConfig.URL_POSTER_W185 + tvShows.posterPath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                    ).into(imgPoster)
                tvVote.text = tvShows.vote_average.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteVieHolder {
        val itemMovieBinding =
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteVieHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: FavoriteVieHolder, position: Int) {
        val tvShows = getItem(position)
        if (tvShows != null) {
            holder.bind(tvShows)
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}