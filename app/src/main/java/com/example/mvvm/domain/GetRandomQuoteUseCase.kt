package com.example.mvvm.domain

import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    private val repository = QuoteRepository()

    /*
    no utilizamos corrutinas por que la info ya se encuentra almacenada en memoria.

     */
    operator fun invoke():QuoteModel?{
        val quotes = QuoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }

}