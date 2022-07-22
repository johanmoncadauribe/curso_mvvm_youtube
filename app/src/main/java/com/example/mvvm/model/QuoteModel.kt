package com.example.mvvm.model

//data va adelante por que es un modeo de datos y recibe dos parametros
/*
A simple vista podemos ver varias cosas, la primera que a diferencia de una clase normal esta
no lleva llaves y la clase va precedida por «data». Esto le dice a Kotlin que esta clase va a
tener por defecto una serie de funciones (aunque no vamos a tener que generarlas nosotros, lo
hará el propio lenguaje por detrás) que podremos usar para rellenar dichos campos.
 */
data class QuoteModel(val quote:String, val author:String) {



}