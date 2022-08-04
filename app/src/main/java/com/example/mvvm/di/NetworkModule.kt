package com.example.mvvm.di

import com.example.mvvm.data.network.QuoteApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

/*
Este sería nuestro primer módulo que actualmente no inyecta nada pero hay cosas que debemos ver.
Lo primero es que es obligatorio añadirle la etiqueta @Module, ya que sino no proveerá nada.

Fíjate que contiene una segunda etiqueta llamada @IntallIn(), que será la encargada de definir
el alcance de nuestras dependencias. ¿A qué me refiero? Cuando este módulo nos provea de alguna
dependencia, lo que hará dagger será crear una instancia y esta no morirá hasta que se salga
del alcance definido. Por ejemplo si necesitamos inyectar Retrofit en una activity (y ponemos
alcance a nivel de activity), cada vez que esa clase pida Retrofit creará una instancia nueva,
pero morirán cuando dicha activity muera.
 */
/*
los modulos proveen dependencias
 */
@Module
@InstallIn(SingletonComponent::class)  //se le dice el alcance que se quiere q tenga la clase objeto
object NetworkModule {

    //cuando se provea retrofit las instancias moriran cuando el activity muera.
    @Singleton //para que mantenga una unica instancia aplicando patron singleton
    @Provides
    fun provideRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providerQuoteApiClient(retrofit: Retrofit): QuoteApiClient{
        return retrofit.create(QuoteApiClient::class.java)
    }
}