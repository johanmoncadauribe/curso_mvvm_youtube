package com.example.mvvm.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.domain.GetQuotesUseCase
import kotlinx.coroutines.launch

/*
    Se convierte la clase a viewmodel, es decir, se extienda la clas ViewModel y ya.
 */

class QuoteViewModel : ViewModel(){

    var getQuotesUseCase = GetQuotesUseCase()

    /*
    Ahora si podríamos llamarlo en nuestra función onCreate()
    pero si recuerdas, nuestro caso de uso es suspend ya que se
    trata de una corrutina así que para poder lanzarlo desde aquí
    tendremos que usar ViewModelScope


     */
    fun onCreate() {
        /*
        ViewModelScope permite crear una corrotina que se controla automaticamente, es decir, en debido caso que se deba detener
        lo hara solita, evitando que la app se crashee
         */
        viewModelScope.launch {
            val result = getQuotesUseCase()
            if(!result.isNullOrEmpty()){
                _quoteModel.postValue(result[0])
            }
        }

    }

    /*
    Luego estamos implementando LiveData, que no es más que un tipo de datos al cual nuestra activity se puede conectar para saber cuando hay un
    cambio en dicho modelo. Por eso fíjate que quoteModel es un MutableLiveData<QuoteModel>, es decir, es live data para que la actividad se
    pueda conectar, pero como el valor va a ser modificado es mutable y ese modelo de datos encapsula el objeto que queremos acceder, en este
    caso será un QuoteModel porque iremos cambiando la cita cada vez que el usuario toque la pantalla.

    el quoteModel se encapsula para evitar que las clases donde se llama no se pueda modificar y solo se pueda
    desde esta misma clases.
     */
    private val _quoteModel = MutableLiveData<QuoteModel>() //Se declara privado y es la q se usa en esta clase
    val quoteModel: LiveData<QuoteModel> //la que se llama desde la vista
        get() = _quoteModel //se obtiene todos los datos para el quoteModel

    /*
    Luego tenemos un método que será al que acceda nuestra vista, que primero llama a nuestro provider para que nos devuelva
    una nueva cita (llamaremos a este método cada vez que se pulse la pantalla) y luego se lo añadiremos a nuestro live data
    con postValue(). Y como nuestro objeto ha sido modificado la actividad lo sabrá al momento y pintará los cambios.
     */
    fun randomQuote(){
//        val currentQuote = QuoteProvider.random()
//        _quoteModel.postValue(currentQuote) //se cambia el valor y se le agrega el nuevo (currentQuote)
    }



}