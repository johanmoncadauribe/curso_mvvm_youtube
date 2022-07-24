package com.example.mvvm.data.model

/* clase propia provider momentanea para simular una respuesta a una solicitud
    va a devolver las citas de forma ramdon.
    ¿Qué es un content provider en Android?
    La instancia ContentProvider administra el acceso a un conjunto de datos estructurados
    mediante la manipulación de solicitudes de otras aplicaciones. Todas las formas de acceso
    eventualmente llaman a ContentResolver , que luego llama a un método concreto de ContentProvider
    para obtener acceso
 */
class QuoteProvider {


    /*
        no se puede acceder a la clase, por lo que se crea un companion object y se coloca todo dentro de la clase.
        companion object es la representación de un miembro que se puede llamar directamente del nombre de una clase,
        sin la creación previa de una instancia de dicha clase. Se podría decir que es el equivalente a los miembros
        estáticos de Java, solo que en Kotlin no existe la palabra static
     */
    companion object {
        var quotes:List<QuoteModel> = emptyList()
    }
}