package com.nadji.moviecatalogue.ui.favorite.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nadji.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.nadji.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {
    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var favoriteMovieAdapter: FavoriteMovieAdapter

    private var _fragmentFavoriteMovieBinding: FragmentFavoriteMovieBinding? = null
    private val binding get() = _fragmentFavoriteMovieBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _fragmentFavoriteMovieBinding =
            FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireContext())
            viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]
            favoriteMovieAdapter = FavoriteMovieAdapter()
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getFavMovie().observe(viewLifecycleOwner, { movie ->
                if (movie != null) {
                    binding.progressBar.visibility = View.GONE
                    favoriteMovieAdapter.submitList(movie)
                    favoriteMovieAdapter.notifyDataSetChanged()
                }
            })

            with(binding.rvMovie) {
                layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                adapter = favoriteMovieAdapter
            }
        }
    }
}