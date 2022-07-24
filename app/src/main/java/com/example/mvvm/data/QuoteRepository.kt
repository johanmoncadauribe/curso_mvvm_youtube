package com.example.mvvm.data

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.network.QuoteService

class QuoteRepository {
    /*
    Fíjate que he añadido la instancia de nuestro service,
    si por ejemplo tuviéramos otro service para base de datos lo añadiríamos aquí
    y esta clase se encargaría de ir a base de datos o a internet.
     */
    private val api = QuoteService()
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}