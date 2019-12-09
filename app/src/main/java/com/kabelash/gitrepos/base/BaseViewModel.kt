package com.kabelash.gitrepos.base

import androidx.lifecycle.ViewModel
import com.kabelash.gitrepos.injection.component.DaggerViewModelInjector
import com.kabelash.gitrepos.injection.component.ViewModelInjector
import com.kabelash.gitrepos.injection.module.NetworkModule
import com.kabelash.gitrepos.ui.PostListViewModel
import com.kabelash.gitrepos.ui.PostViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    //Injects the required dependencies
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}