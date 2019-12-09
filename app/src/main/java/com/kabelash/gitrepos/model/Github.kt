package com.kabelash.gitrepos.model

data class Github (

    //Only created the required objects
    val id : String,
    val node_id : String,
    val name : String,
    val full_name : String,
    val owner : Owner,
    val html_url : String,
    val description : String
)