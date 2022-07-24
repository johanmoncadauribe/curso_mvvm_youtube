package com.example.mvvm.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
¿Por qué un objeto? Normalmente si queremos acceder al contenido de una clase o creamos un objeto de esa clase o
añadimos un companion object así que creo que esta es la forma más limpia de hacerlo.
 */
object RetrofitHelper {

    /*
    Básicamente creamos una función que al llamarla nos devuelve una instancia de Retrofit preparada para usar.
     */
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}