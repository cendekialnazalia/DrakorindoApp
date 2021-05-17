package com.cendekia.drakorindoapp.ui.detail

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.cendekia.drakorindoapp.R
import com.cendekia.drakorindoapp.data.source.local.entity.VarietyEntity
import com.cendekia.drakorindoapp.databinding.ActivityDetailVarietyShowBinding
import com.cendekia.drakorindoapp.databinding.ContentDetailVarietyShowBinding
import com.cendekia.drakorindoapp.viewmodel.ViewModelFactory
import com.cendekia.drakorindoapp.vo.Status

class DetailVarietyShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_VARIETY = "extra_variety"
    }

    private lateinit var activityDetailVarietyBinding: ActivityDetailVarietyShowBinding
    private lateinit var detailContentVarietyShowBinding: ContentDetailVarietyShowBinding

    private lateinit var viewModel: DetailViewModel
    private var menu: Menu? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailVarietyBinding =
            ActivityDetailVarietyShowBinding.inflate(layoutInflater)
        detailContentVarietyShowBinding = activityDetailVarietyBinding.detailContentVariety

        setContentView(activityDetailVarietyBinding.root)

        setSupportActionBar(activityDetailVarietyBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val varietyId = extras.getString(DetailVarietyShowActivity.EXTRA_VARIETY)
            if (varietyId != null) {
                viewModel.setSelectedVariety(varietyId)

                viewModel.varietyModule.observe(this, Observer { varietyWithModuleResource ->
                    if (varietyWithModuleResource != null) {
                        when (varietyWithModuleResource.status) {
                            Status.LOADING -> activityDetailVarietyBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (varietyWithModuleResource.data != null) {
                                activityDetailVarietyBinding.progressBar.visibility = View.GONE
                                populateDrakorindo(varietyWithModuleResource.data.mVariety)
                            }
                            Status.ERROR -> {
                                activityDetailVarietyBinding.progressBar.visibility = View.GONE
                                Toast.makeText(
                                    applicationContext,
                                    "Terjadi kesalahan",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                })
            }
        }

    }

    private fun populateDrakorindo(varietyEntity: VarietyEntity) {
        detailContentVarietyShowBinding.textTitleVariety.text = varietyEntity.title
        detailContentVarietyShowBinding.textTypeDurationVariety.text = varietyEntity.typeDuration
        detailContentVarietyShowBinding.textOverviewVariety.text = varietyEntity.overview
        detailContentVarietyShowBinding.textCreatorVariety.text = varietyEntity.creator
        Glide.with(this)
            .load(varietyEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentVarietyShowBinding.imgPosterVariety)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.varietyModule.observe(this, Observer { varietyWithModule ->
            if (varietyWithModule != null) {
                when (varietyWithModule.status) {
                    Status.LOADING -> activityDetailVarietyBinding.progressBar.visibility =
                        View.VISIBLE
                    Status.SUCCESS -> if (varietyWithModule.data != null) {
                        activityDetailVarietyBinding.progressBar.visibility = View.GONE
                        val state = varietyWithModule.data.mVariety.favorited
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailVarietyBinding.progressBar.visibility = View.GONE
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_favorite) {
            viewModel.setVarietyFavorite()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setFavoriteState(state: Boolean) {
        if (menu == null) return
        val menuItem = menu?.findItem(R.id.action_favorite)
        if (state) {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorited_red)
        } else {
            menuItem?.icon = ContextCompat.getDrawable(this, R.drawable.ic_favorite_red)
        }
    }
}