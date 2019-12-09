package com.kabelash.gitrepos.injection.component

import dagger.Component
import com.kabelash.gitrepos.injection.module.NetworkModule
import com.kabelash.gitrepos.ui.PostListViewModel
import com.kabelash.gitrepos.ui.PostViewModel
import javax.inject.Singleton

//Component providing inject() methods for presenters
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    //Injects required dependencies into the specified PostListViewModel.
    fun inject(postListViewModel: PostListViewModel)

    fun inject(postViewModel: PostViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}