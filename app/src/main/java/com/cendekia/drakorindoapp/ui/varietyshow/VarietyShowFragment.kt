package com.cendekia.drakorindoapp.ui.varietyshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.cendekia.drakorindoapp.databinding.FragmentVarietyShowBinding
import com.cendekia.drakorindoapp.viewmodel.ViewModelFactory
import com.cendekia.drakorindoapp.vo.Status

class VarietyShowFragment : Fragment() {

    private lateinit var fragmentVarietyShowBinding: FragmentVarietyShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentVarietyShowBinding =
            FragmentVarietyShowBinding.inflate(layoutInflater, container, false)
        return fragmentVarietyShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[VarietyShowViewModel::class.java]

            val varietyAdapter = VarietyShowAdapter()
            viewModel.getVarietyShows().observe(viewLifecycleOwner, Observer { varietises ->
                if (varietises != null) {
                    when (varietises.status) {
                        Status.LOADING -> fragmentVarietyShowBinding?.progressBar?.visibility =
                            View.VISIBLE
                        Status.SUCCESS -> {
                            fragmentVarietyShowBinding?.progressBar?.visibility = View.GONE
                            varietyAdapter.submitList(varietises.data)
                        }
                        Status.ERROR -> {
                            fragmentVarietyShowBinding?.progressBar?.visibility = View.GONE
                            Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
            with(fragmentVarietyShowBinding?.rvVariety) {
                this?.layoutManager =
                    StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                this?.setHasFixedSize(true)
                this?.adapter = varietyAdapter
            }
        }
    }
}