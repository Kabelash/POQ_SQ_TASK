package com.kabelash.gitrepos.ui

import androidx.lifecycle.Observer
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.kabelash.gitrepos.R
import com.kabelash.gitrepos.databinding.ActivityMainBinding

class RecyclerListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: PostListViewModel
    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel = ViewModelProviders.of(this).get(PostListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
            errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}