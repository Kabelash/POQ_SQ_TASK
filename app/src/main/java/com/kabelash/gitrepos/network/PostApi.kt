package com.kabelash.gitrepos.network

import com.kabelash.gitrepos.model.Github
import io.reactivex.Observable
import retrofit2.http.GET

interface PostApi {

    //Get the list of the repos from the API
    @GET("orgs/square/repos")
    fun getPosts(): Observable<List<Github>>
}