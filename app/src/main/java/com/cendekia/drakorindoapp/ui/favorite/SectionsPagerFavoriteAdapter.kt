package com.cendekia.drakorindoapp.ui.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.cendekia.drakorindoapp.R
import com.cendekia.drakorindoapp.ui.favorite.drama.FavoriteDramaFragment
import com.cendekia.drakorindoapp.ui.favorite.variety.FavoriteVarietyFragment

class SectionsPagerFavoriteAdapter(private val mContext: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.drama, R.string.variety_show)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteDramaFragment()
            1 -> FavoriteVarietyFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence? =
        mContext.resources.getString(TAB_TITLES[position])

    override fun getCount(): Int = 2

}