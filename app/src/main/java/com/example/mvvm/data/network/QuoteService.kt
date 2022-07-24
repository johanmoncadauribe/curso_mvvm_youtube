package com.example.mvvm.data.network

import com.example.mvvm.core.RetrofitHelper
import com.example.mvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


/*
    crearemos una nueva clase llamada QuoteService, que será la clase a la que
    llame nuestro repositorio (cuando lo creemos) cuando queramos datos de internet
    y esta clase ya gestionaría la llamada a Retrofit o a Firebase por ejemplo.
 */
class QuoteService {

    /*
    Para empezar tenemos una instancia de nuestro RetrofitHelper y luego tenemos una función que llamará a
    nuestra interfaz. Dentro de la función getQuotes() estamos creando una corrutina de tipo IO que serán las
    óptimas para hacer llamadas de red o a bases de datos y esto retornará lo que se haga dentro.
Con esta clase conseguimos abstraer la parte de Retrofit al máximo, es decir, si un día queremos cambiar los
endpoints solo deberemos tocar esta clase y el resto de nuestra app quedará intacta.
Por decirlo de algún modo, esta clase será la puerta de acceso a internet y dicha puerta será llamada por el repositorio
     */
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getQuotes(): List<QuoteModel> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }

}