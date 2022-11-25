package com.example.ejemplocompose

sealed class Destinos(
    val rutas : String
) {
    object PantallaMyapp: Destinos("myapp")
    object PantallaInvetario: Destinos("inventario")
}