package com.example.navigation1.screens

import android.text.TextUtils
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


@Composable
fun HomeView(navController: NavHostController){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Inicio")
        Button(onClick = {
            navController.navigate("SegundaPantalla")
        }) {
            Text(text = "Siguiente")
        }
    }
}

@Composable
fun SecondView(navController: NavHostController){
    var  age:String by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "SegundaPantalla -|-|-|-|-|- ¿Cuál es su edad?")
        TextField(value = age, onValueChange= {
            age = it })
        Row(){
            Button(onClick = {
                navController.navigate("TerceraPantalla/$age")
            }) {
                Text(text = "Ir a la pantalla final")
            }
        }
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Regresar")
        }
    }
}

@Composable
fun ThirdView(navController: NavHostController,age:Int){
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Su edad es $age")
    }
}

