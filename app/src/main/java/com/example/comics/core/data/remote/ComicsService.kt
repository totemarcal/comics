package com.example.comics.core.data.remote

import com.example.comics.core.data.remote.response.ItemModel
import retrofit2.http.GET

interface ComicsService {

    @GET("comics")
    suspend fun getComics() : ItemModel

}