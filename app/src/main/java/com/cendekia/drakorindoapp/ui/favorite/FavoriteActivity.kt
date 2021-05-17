package com.cendekia.drakorindoapp.ui.favorite

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cendekia.drakorindoapp.R
import com.cendekia.drakorindoapp.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private var _activityFavoriteBinding: ActivityFavoriteBinding? = null
    private val binding get() = _activityFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _activityFavoriteBinding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        setSupportActionBar(_activityFavoriteBinding?.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val sectionsPagerFavoriteAdapter =
            SectionsPagerFavoriteAdapter(this, supportFragmentManager)
        binding?.viewPager?.adapter = sectionsPagerFavoriteAdapter
        binding?.tabs?.setupWithViewPager(binding?.viewPager)
        supportActionBar?.elevation = 0f
    }
}