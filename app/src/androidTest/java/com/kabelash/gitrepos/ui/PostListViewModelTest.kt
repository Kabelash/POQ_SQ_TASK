package com.kabelash.gitrepos.ui

import android.app.Activity
import android.content.Intent
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify


class PostListViewModelTest : Assert() {

    private var viewModel: PostListViewModel? = null
    private var activity: Activity? = null

    @Before
    fun setUp() {
        activity = mock(RecyclerListActivity::class.java)
        viewModel = PostListViewModel()
    }

    @Test
    fun testOnClicks() {
    }

}