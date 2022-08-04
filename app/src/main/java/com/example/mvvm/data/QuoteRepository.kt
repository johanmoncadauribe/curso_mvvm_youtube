package com.example.mvvm.data

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
){
    /*
    Fíjate que he añadido la instancia de nuestro service,
    si por ejemplo tuviéramos otro service para base de datos lo añadiríamos aquí
    y esta clase se encargaría de ir a base de datos o a internet.
     */
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}