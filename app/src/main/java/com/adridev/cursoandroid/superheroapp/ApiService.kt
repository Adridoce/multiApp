package com.adridev.cursoandroid.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/5928799777240589/search/{name}")
    suspend fun getSuperHeros(@Path("name") superHeroName:String):Response<SuperHeroDataResponse>
}