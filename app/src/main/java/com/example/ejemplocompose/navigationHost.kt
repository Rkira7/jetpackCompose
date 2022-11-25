package com.example.ejemplocompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejemplocompose.Destinos.*

@Composable
fun NavigationHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = PantallaMyapp.rutas ){
        composable(PantallaMyapp.rutas){
            MyApp1(
                navController = navController
//                navegarInvetario = {
//                    navController.navigate(PantallaInvetario.rutas)
//                }
            )
        }

        composable(PantallaInvetario.rutas){
            PantallaInventario()
        }

    }
}