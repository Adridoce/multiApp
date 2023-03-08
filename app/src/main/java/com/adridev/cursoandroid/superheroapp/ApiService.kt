package com.adridev.cursoandroid.superheroapp

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    // clave api
    @GET("api/5928799777240589/search/{name}")
    suspend fun getSuperHeros(@Path("name") superHeroName:String):Response<SuperHeroDataResponse>

    @GET("/api/5928799777240589/{id}")
    suspend fun getSuperheroDetail(@Path("id") superheroId:String):Response<SuperheroDetailResponse>
}