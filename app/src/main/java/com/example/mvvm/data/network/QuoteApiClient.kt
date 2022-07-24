package com.example.mvvm.data.network

import com.example.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {

    /*
    Se trata de una petición get que nos devolverá un listado de QuoteModel.
    Lo único interesante es que se trata de una función suspend ya que será a través de una corrutina.
     */
    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>

}