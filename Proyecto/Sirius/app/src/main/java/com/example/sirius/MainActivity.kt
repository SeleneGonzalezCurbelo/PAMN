package com.example.sirius

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sirius.ui.theme.SiriusTheme
import com.example.sirius.view.screens.AnimalScreens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiriusTheme {
                AnimalScreens()
            }
        }
    }
}