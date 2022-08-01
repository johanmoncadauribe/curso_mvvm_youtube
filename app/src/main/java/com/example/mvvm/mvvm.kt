package com.example.mvvm

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
Inicializar Dagger Hilt es extremadamente sencillo. Lo primero que necesitaremos
será tener una clase application, es decir, una clase que se ejecutará antes de
empezar la app.

Crearla es similar a cualquier otra clase, vamos al directorio que queramos,

Para que sea una clase application solo tenemos que hacer que extienda de Application()
como el ejemplo anterior. Y para que Dagger Hilt se configure, basta con añadir la anotación
@HiltAndroidApp encima de la clase.
https://cursokotlin.com/dagger-hilt-inyeccion-de-dependencias-mvvm/
 */
@HiltAndroidApp
class mvvm:Application()