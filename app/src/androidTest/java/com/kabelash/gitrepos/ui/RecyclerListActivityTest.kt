package com.kabelash.gitrepos.ui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kabelash.gitrepos.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class RecyclerListActivityTest{

    @Rule @JvmField
    var activityRule = ActivityTestRule<RecyclerListActivity>(
        RecyclerListActivity::class.java
    )

    //Testing the progress bar displayed
    @Test
    fun progressBarLoadingTest(){
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    }

    //Testing 5th item click on RecyclerView
    @Test
    fun recyclerTest(){
        //onView(withId(R.id.post_list)).perform(RecyclerViewActions.scrollToPosition<PostListAdapter.ViewHolder>(11))
        onView(withId(R.id.post_list)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5,ViewActions.click()))
        //onView(withId(R.id.post_title)).check(matches(withText("gh-unit")))
    }

}
