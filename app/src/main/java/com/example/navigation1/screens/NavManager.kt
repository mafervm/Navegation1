package com.example.navigation1.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.navArgument

@Preview(showBackground = true)
@Composable
fun NavManager(){
    var navController:NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "PrimerPantalla"){
        //definiendo rutas
        composable(route = "PrimerPantalla"){
            HomeView(navController)
        }
        composable(route = "SegundaPantalla") {
            SecondView(navController)
        }
        composable(route = "TerceraPantalla/{age}",
            arguments = listOf(
                navArgument("age"){
                    type = NavType.IntType
                }
            )
        ){
            parametros ->
            var edad:Int = parametros.arguments?.getInt("age") ?:0
            ThirdView(navController, edad)
        }
    }
}