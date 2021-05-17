package com.cendekia.drakorindoapp.ui.favorite.drama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cendekia.drakorindoapp.R
import com.cendekia.drakorindoapp.databinding.FragmentFavoriteDramaBinding
import com.cendekia.drakorindoapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteDramaFragment : Fragment() {

    lateinit var fragmentFavoriteDramaBinding: FragmentFavoriteDramaBinding
    private lateinit var viewModel: FavoriteDramaViewModel
    private lateinit var adapterFav: FavoriteDramaAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentFavoriteDramaBinding =
            FragmentFavoriteDramaBinding.inflate(inflater, container, false)
        return fragmentFavoriteDramaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentFavoriteDramaBinding.rvFavoriteDrama)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteDramaViewModel::class.java]

            adapterFav = FavoriteDramaAdapter()
            fragmentFavoriteDramaBinding.progressBar.visibility = View.VISIBLE
            viewModel.getDramaFavorites().observe(viewLifecycleOwner, Observer {
                fragmentFavoriteDramaBinding.progressBar.visibility = View.GONE
                adapterFav.submitList(it)
            })
            with(fragmentFavoriteDramaBinding.rvFavoriteDrama) {
                layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                setHasFixedSize(true)
                this.adapter = adapterFav
            }
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder
        ): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.absoluteAdapterPosition
                val courseEntity = adapterFav.getSwipedData(swipedPosition)
                courseEntity?.let { viewModel.setFavorite(it) }
                val snackbar =
                    Snackbar.make(view as View, R.string.message_undo, Snackbar.LENGTH_LONG)
                snackbar.setAction(R.string.message_ok) {
                    courseEntity?.let { viewModel.setFavorite(it) }
                }
                snackbar.show()
            }
        }
    })
}