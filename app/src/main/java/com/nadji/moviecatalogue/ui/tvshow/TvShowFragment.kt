package com.nadji.moviecatalogue.ui.tvshow

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.GridLayoutManager
import com.nadji.moviecatalogue.R
import com.nadji.moviecatalogue.data.source.local.entity.TvShowEntity
import com.nadji.moviecatalogue.databinding.FragmentTvShowBinding
import com.nadji.moviecatalogue.utils.SortUtils
import com.nadji.moviecatalogue.utils.SortUtils.VOTE_BEST
import com.nadji.moviecatalogue.viewmodel.ViewModelFactory
import com.nadji.moviecatalogue.vo.Resource
import com.nadji.moviecatalogue.vo.Status

class TvShowFragment : Fragment() {
    private lateinit var viewModel: TvShowViewModel
    private lateinit var tvShowAdapter: TvShowAdapter

    private var _fragmentTvShowBinding: FragmentTvShowBinding? = null
    private val binding get() = _fragmentTvShowBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
            tvShowAdapter = TvShowAdapter()

            viewModel.getTvShow(VOTE_BEST).observe(viewLifecycleOwner, tvObserver)

            with(binding.rvTvshow) {
                layoutManager = GridLayoutManager(context, 3)
                setHasFixedSize(true)
                adapter = tvShowAdapter
            }
        }
    }

    private val tvObserver = Observer<Resource<PagedList<TvShowEntity>>> { tvShows ->
        if (tvShows.data != null) {
            when (tvShows.status) {
                Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    tvShowAdapter.submitList(tvShows.data)
                    tvShowAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(context, R.string.error_load_tv, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.menu_main, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var sort = ""
        when (item.itemId) {
            R.id.action_best -> sort = VOTE_BEST
            R.id.action_worst -> sort = SortUtils.VOTE_WORST
            R.id.action_random -> sort = SortUtils.RANDOM
        }
        viewModel.getTvShow(sort).observe(viewLifecycleOwner, tvObserver)
        return super.onOptionsItemSelected(item)
    }
}