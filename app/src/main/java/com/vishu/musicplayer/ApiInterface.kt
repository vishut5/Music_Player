package com.vishu.musicplayer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @Headers("X-RapidAPI-Key: 3261735cbfmshf3804a072f3fbbep1bdf7fjsnb4d25337e1d0",
        "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com")
    @GET("search")
    fun getData(@Query("q") query : String ) : Call<MusicData>

}