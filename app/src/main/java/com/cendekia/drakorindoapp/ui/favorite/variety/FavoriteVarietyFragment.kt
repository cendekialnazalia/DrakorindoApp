package com.cendekia.drakorindoapp.ui.favorite.variety

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
import com.cendekia.drakorindoapp.databinding.FragmentFavoriteVarietyBinding
import com.cendekia.drakorindoapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class FavoriteVarietyFragment : Fragment() {

    lateinit var fragmentVarietyShowBinding: FragmentFavoriteVarietyBinding
    private lateinit var viewModel: FavoriteVarietyViewModel
    private lateinit var adapterFavorite: FavoriteVarietyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentVarietyShowBinding =
            FragmentFavoriteVarietyBinding.inflate(inflater, container, false)
        return fragmentVarietyShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemTouchHelper.attachToRecyclerView(fragmentVarietyShowBinding.rvFavoriteVariety)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteVarietyViewModel::class.java]


            adapterFavorite = FavoriteVarietyAdapter()
            fragmentVarietyShowBinding.progressBar.visibility = View.VISIBLE
            viewModel.getVarietyFavorites().observe(viewLifecycleOwner, Observer {
                fragmentVarietyShowBinding.progressBar.visibility = View.GONE
                adapterFavorite.submitList(it)
            })
            with(fragmentVarietyShowBinding.rvFavoriteVariety) {
                layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                setHasFixedSize(true)
                this.adapter = adapterFavorite
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
                val courseEntity = adapterFavorite.getSwipedData(swipedPosition)
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