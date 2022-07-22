package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewModel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    /*
    conectar el viewmodel con el activity

     */
     /*  Gracias a la librería de activity que añadimos al principio, asignar un ViewModel es mas sencillo.
       Solo tenemos que crear un atributo de clase definiendo nuestro ViewModel y llamar a by viewModels().
    */
    private val quoteViewModel: QuoteViewModel by viewModels()
    /*
    url del curso con explicacion
    https://cursokotlin.com/mvvm-en-android-con-kotlin-livedata-y-view-binding-android-architecture-components/
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observes()
        eventoOnclic()
    }

    /*
    Con esto ya lo tenemos, pero nos queda suscribirnos a los cambios. Como dije anteriormente live data es
    básicamente el patrón observe por lo que definirlo es muy sencillo.
    Simplemente llamamos a nuestro ViewModel y dentro de este accedemos a nuestro objeto con live data para llamar a la función observe().
    Dentro le pasaremos el owner que es this y aquí lleva una función Observer{}, fíjate que al valor que retorna lo he llamado currentQuote,
     para ello solo tengo que ponerlo al principio y añadir -> pero podríamos borrar eso y acceder con un it.
     */
    fun observes(){
/*
        Lo mejor seria hacerlo con el it, pero se deja comentareado como referencia de dos formas de resolver
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
        })
 */
        /*
        cada vez que ocurra un cambio se detecta y cambiara la vista
         */
        quoteViewModel.quoteModel.observe(this, Observer {
            binding.tvQuote.text = it.quote
            binding.tvAuthor.text = it.author
        })
    }

    fun eventoOnclic(){
        binding.viewContainer.setOnClickListener{
            /*
            se llama al quoteViewModel que ya fue declarado y se ejecuta el metodo random que se creo
             */
            quoteViewModel.randomQuote()
        }
    }

}