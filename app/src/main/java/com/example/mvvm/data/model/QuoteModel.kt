package com.example.mvvm.data.model

import com.google.gson.annotations.SerializedName

//data va adelante por que es un modeo de datos y recibe dos parametros
/*
A simple vista podemos ver varias cosas, la primera que a diferencia de una clase normal esta
no lleva llaves y la clase va precedida por «data». Esto le dice a Kotlin que esta clase va a
tener por defecto una serie de funciones (aunque no vamos a tener que generarlas nosotros, lo
hará el propio lenguaje por detrás) que podremos usar para rellenar dichos campos.
 */
/*
El modelo de datos será igual que el actual (QuoteModel), pero podemos ponerle el atributo @SerializedName si el nombre puede cambiar.
 */
data class QuoteModel(@SerializedName("quote") val quote: String,
                      @SerializedName("author") val author: String) {



}