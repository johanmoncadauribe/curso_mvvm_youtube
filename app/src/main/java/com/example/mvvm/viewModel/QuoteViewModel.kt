package com.example.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm.model.QuoteModel
import com.example.mvvm.model.QuoteProvider

/*
    Se convierte la clase a viewmodel, es decir, se extienda la clas ViewModel y ya.

 */

class QuoteViewModel : ViewModel(){

    /*
    Luego estamos implementando LiveData, que no es más que un tipo de datos al cual nuestra activity se puede conectar para saber cuando hay un
    cambio en dicho modelo. Por eso fíjate que quoteModel es un MutableLiveData<QuoteModel>, es decir, es live data para que la actividad se
    pueda conectar, pero como el valor va a ser modificado es mutable y ese modelo de datos encapsula el objeto que queremos acceder, en este
    caso será un QuoteModel porque iremos cambiando la cita cada vez que el usuario toque la pantalla.
     */
    val quoteModel = MutableLiveData<QuoteModel>()

    /*
    Luego tenemos un método que será al que acceda nuestra vista, que primero llama a nuestro provider para que nos devuelva
    una nueva cita (llamaremos a este método cada vez que se pulse la pantalla) y luego se lo añadiremos a nuestro live data
    con postValue(). Y como nuestro objeto ha sido modificado la actividad lo sabrá al momento y pintará los cambios.
     */
    fun randomQuote(){
        val currentQuote = QuoteProvider.random()
        quoteModel.postValue(currentQuote) //se cambia el valor y se le agrega el nuevo (currentQuote)
    }

}