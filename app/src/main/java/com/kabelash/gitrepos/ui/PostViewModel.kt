package com.kabelash.gitrepos.ui

import androidx.lifecycle.MutableLiveData
import com.kabelash.gitrepos.base.BaseViewModel
import com.kabelash.gitrepos.model.Github

class PostViewModel: BaseViewModel() {
    private val postTitle = MutableLiveData<String>()
    private val postBody = MutableLiveData<String>()
    private val postImgUrl = MutableLiveData<String>()

    fun bind(post: Github){
        postTitle.value = post.name
        postBody.value = post.description
        postImgUrl.value = post.owner.avatar_url
    }

    fun getPostTitle():MutableLiveData<String>{
        return postTitle
    }

    fun getPostBody():MutableLiveData<String>{
        return postBody
    }

    fun getPostImgUrl():MutableLiveData<String>{
        return postImgUrl
    }
}