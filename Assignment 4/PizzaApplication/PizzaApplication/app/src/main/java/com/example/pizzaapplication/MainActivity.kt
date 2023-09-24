package com.example.pizzaapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pizzaapplication.pizza.data.navigation.PizzaNavigation
import com.example.pizzaapplication.pizza.data.navigation.home
import com.example.pizzaapplication.pizza.data.screens.HomeScreen
import com.example.pizzaapplication.ui.theme.PizzaApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaNavigation()
        }
    }
}
