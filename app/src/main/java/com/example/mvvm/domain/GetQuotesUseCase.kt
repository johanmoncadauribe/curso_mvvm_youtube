package com.example.mvvm.domain

import com.example.mvvm.data.QuoteRepository
import com.example.mvvm.data.model.QuoteModel
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor() {
/*
Este sería el caso de uso más básico, el cual solo llama al repositorio para decirle que recupere de internet todas las citas.
Fíjate que la función es algo extraña ya que con el operator invoke podemos llamar a esa función
 sin tener que darle un nombre, es decir con hacer GetQuotesUseCase() ya se estaría llamando, similar a un constructor pero sin
 tener que pasarle los parámetros.
 */

    private val repository = QuoteRepository()
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}