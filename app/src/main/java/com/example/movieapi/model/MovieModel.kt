package com.example.movieapi.model

import java.io.Serializable

data class MovieModel(
    val Title:String?,
    val Year:String?,
    val Genre:String?,
    val Awards:String?,
    val Poster:String?,
    val imdbRating:String?
):Serializable
