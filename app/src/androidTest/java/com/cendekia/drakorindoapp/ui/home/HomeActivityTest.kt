package com.cendekia.drakorindoapp.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.cendekia.drakorindoapp.R
import com.cendekia.drakorindoapp.utils.DataDrama
import com.cendekia.drakorindoapp.utils.DataVarietyShow
import com.cendekia.drakorindoapp.utils.EspressoIdlingResource
import org.hamcrest.CoreMatchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyDrama = DataDrama.generateDummyDrama()
    private val dummyVariety = DataVarietyShow.generateDummyVarietyShow()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }


    @Test
    fun loadVariety() {
        onView(allOf(withId(R.id.rv_drama), isDisplayed())).perform(swipeLeft())
        onView(allOf(withId(R.id.rv_variety), isDisplayed()))
        onView(
            allOf(
                withId(R.id.rv_variety),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyVariety.size))
    }

    @Test
    fun loadDetailVariety() {
        onView(allOf(withId(R.id.rv_drama), isDisplayed())).perform(swipeLeft())
        onView(allOf(withId(R.id.rv_variety))).perform(
            (RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                doubleClick()
            ))
        )
        onView(withId(R.id.text_title_variety))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_type_duration_variety))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_overview_variety))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_creator_variety))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.img_poster_variety))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun loadDrama() {
        onView(allOf(withId(R.id.rv_drama), isDisplayed()))
        onView(
            allOf(
                withId(R.id.rv_drama),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyDrama.size))
    }

    @Test
    fun loadDetailDrama() {
        onView(allOf(withId(R.id.rv_drama), isDisplayed())).perform(
            (RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            ))
        )
        onView(withId(R.id.text_title))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_type_duration))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_overview))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.text_creator))
            .check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.img_poster))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteDrama() {
        onView(withId(R.id.rv_drama)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.action_favorite)).perform(click())
        onView(ViewMatchers.isRoot()).perform(pressBack())
        onView(withId(R.id.favorite_menu)).perform(click())
        onView(withId(R.id.rv_favorite_drama)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0 ,
                click()
            )
        )
        onView(withId(R.id.action_favorite)).perform(click())
        onView(ViewMatchers.isRoot()).perform(pressBack())
//        onView(withId(R.id.rv_favorite_drama)).check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun loadFavoriteVariety() {
        onView(allOf(withId(R.id.rv_drama), isDisplayed())).perform(swipeLeft())
        onView(withId(R.id.rv_variety)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                doubleClick()
            )
        )
        onView(withId(R.id.action_favorite)).perform(click())
        onView(ViewMatchers.isRoot()).perform(pressBack())
        onView(withId(R.id.favorite_menu)).perform(click())
        onView(allOf(withId(R.id.rv_favorite_drama), isDisplayed())).perform(swipeLeft())
        onView(
            allOf(
                withId(R.id.rv_favorite_variety),
                isDisplayed()
            )
        ).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyVariety.size))
        onView(withId(R.id.rv_favorite_variety)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0 ,
                doubleClick()
            )
        )
        onView(withId(R.id.action_favorite)).perform(click())
        onView(ViewMatchers.isRoot()).perform(pressBack())
    }
}