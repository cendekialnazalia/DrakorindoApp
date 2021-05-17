package com.cendekia.drakorindoapp.ui.drama

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cendekia.drakorindoapp.databinding.FragmentDramaBinding
import com.cendekia.drakorindoapp.viewmodel.ViewModelFactory
import com.cendekia.drakorindoapp.vo.Status

class DramaFragment : Fragment() {

    private lateinit var fragmentDramaBinding: FragmentDramaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentDramaBinding = FragmentDramaBinding.inflate(layoutInflater, container, false)
        return fragmentDramaBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[DramaViewModel::class.java]

            val dramaAdapter = DramaAdapter()
            viewModel.getDramas().observe(viewLifecycleOwner, Observer { dramases ->
                if (dramases != null) {
                    when (dramases.status) {
                        Status.LOADING -> fragmentDramaBinding.progressBar.visibility = View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentDramaBinding.progressBar.visibility = View.GONE
                            dramaAdapter.submitList(dramases.data)
                        }
                        Status.ERROR -> {
                            fragmentDramaBinding.progressBar.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(fragmentDramaBinding.rvDrama) {
                layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                setHasFixedSize(true)
                this.adapter = dramaAdapter
            }
        }
    }
}