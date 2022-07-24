package com.example.mvvm.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.domain.GetQuotesUseCase
import com.example.mvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch

/*
    Se convierte la clase a viewmodel, es decir, se extienda la clas ViewModel y ya.
 */

class QuoteViewModel : ViewModel(){

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

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private var getQuotesUseCase = GetQuotesUseCase()
    private var getRandomQuoteUseCase = GetRandomQuoteUseCase()

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
            _isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                _quoteModel.postValue(result[0])
                _isLoading.postValue(false)
            }else{
                _quoteModel.postValue(QuoteModel("ERROR DE RED","COMPRUEBE SU CONEXIÓN"))
                _isLoading.postValue(false)
            }

        }

    }



    /*
    Luego tenemos un método que será al que acceda nuestra vista, que primero llama a nuestro provider para que nos devuelva
    una nueva cita (llamaremos a este método cada vez que se pulse la pantalla) y luego se lo añadiremos a nuestro live data
    con postValue(). Y como nuestro objeto ha sido modificado la actividad lo sabrá al momento y pintará los cambios.
     */
    fun randomQuote(){
        _isLoading.postValue(true)

        val quote= getRandomQuoteUseCase()
        if(quote!=null){
            _quoteModel.postValue(quote)
        }
        _isLoading.postValue(false)


    }



}