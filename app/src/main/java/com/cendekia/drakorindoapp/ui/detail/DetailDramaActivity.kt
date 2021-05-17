package com.cendekia.drakorindoapp.ui.detail

import android.content.Intent
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
import com.cendekia.drakorindoapp.data.source.local.entity.DramaEntity
import com.cendekia.drakorindoapp.databinding.ActivityDetailDramaBinding
import com.cendekia.drakorindoapp.databinding.ContentDetailDramaBinding
import com.cendekia.drakorindoapp.ui.webview.MyWebView
import com.cendekia.drakorindoapp.viewmodel.ViewModelFactory
import com.cendekia.drakorindoapp.vo.Status

class DetailDramaActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DRAMA = "extra_drama"
    }

    private lateinit var activityDetailDramaBinding: ActivityDetailDramaBinding
    private lateinit var detailContentDramaBinding: ContentDetailDramaBinding

    private lateinit var viewModel: DetailViewModel
    private var menu: Menu? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityDetailDramaBinding = ActivityDetailDramaBinding.inflate(layoutInflater)
        detailContentDramaBinding = activityDetailDramaBinding.detailContentDrama

        setContentView(activityDetailDramaBinding.root)

        setSupportActionBar(activityDetailDramaBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(
            this,
            factory
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val dramaId = extras.getString(EXTRA_DRAMA)
            if (dramaId != null) {
                viewModel.setSelectedDrama(dramaId)

                viewModel.dramaModule.observe(this, Observer { dramaWithModuleResource ->
                    if (dramaWithModuleResource != null) {
                        when (dramaWithModuleResource.status) {
                            Status.LOADING -> activityDetailDramaBinding.progressBar.visibility =
                                View.VISIBLE
                            Status.SUCCESS -> if (dramaWithModuleResource.data != null) {
                                activityDetailDramaBinding.progressBar.visibility = View.GONE
                                populateDrakorindo(dramaWithModuleResource.data.mDrama)
                            }
                            Status.ERROR -> {
                                activityDetailDramaBinding.progressBar.visibility = View.GONE
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

    private fun populateDrakorindo(dramaEntity: DramaEntity) {
        detailContentDramaBinding.textTitle.text = dramaEntity.title
        detailContentDramaBinding.textTypeDuration.text = dramaEntity.typeDuration
        detailContentDramaBinding.textOverview.text = dramaEntity.overview
        detailContentDramaBinding.textCreator.text = dramaEntity.creator
        Glide.with(this)
            .load(dramaEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(detailContentDramaBinding.imgPoster)

        detailContentDramaBinding.btnTeaser.setOnClickListener {
            val intent = Intent(this@DetailDramaActivity, MyWebView::class.java)
            intent.putExtra(MyWebView.EXTRA_LINK, dramaEntity.linkTrailer)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        this.menu = menu
        viewModel.dramaModule.observe(this, Observer { dramaWithModule ->
            if (dramaWithModule != null) {
                when (dramaWithModule.status) {
                    Status.LOADING -> activityDetailDramaBinding.progressBar.visibility =
                        View.VISIBLE
                    Status.SUCCESS -> if (dramaWithModule.data != null) {
                        activityDetailDramaBinding.progressBar.visibility = View.GONE
                        val state = dramaWithModule.data.mDrama.favorited
                        setFavoriteState(state)
                    }
                    Status.ERROR -> {
                        activityDetailDramaBinding.progressBar.visibility = View.GONE
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
            viewModel.setDramaFavorite()
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