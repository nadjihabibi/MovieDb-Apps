package com.nadji.moviecatalogue.ui.favorite.tvshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nadji.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import com.nadji.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {
    private lateinit var viewModel: FavoriteTvViewModel
    private lateinit var favoriteTvAdapter: FavoriteTvAdapter

    private var _fragmentFavoriteTvShowBinding: FragmentFavoriteTvShowBinding? = null
    private val binding get() = _fragmentFavoriteTvShowBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _fragmentFavoriteTvShowBinding =
            FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvViewModel::class.java]
            favoriteTvAdapter = FavoriteTvAdapter()
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavTv().observe(viewLifecycleOwner, { tvShow ->
                if (tvShow != null) {
                    binding.progressBar.visibility = View.GONE
                    favoriteTvAdapter.submitList(tvShow)
                    favoriteTvAdapter.notifyDataSetChanged()
                }
            })
            with(binding.rvTvshow) {
                layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                adapter = favoriteTvAdapter
            }
        }
    }
}