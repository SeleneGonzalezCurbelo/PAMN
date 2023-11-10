package com.example.sirius

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.sirius.ui.theme.SiriusTheme
import com.example.sirius.view.components.AnimalScreens
import com.example.sirius.view.screens.MyComposable
import com.example.sirius.viewmodel.navigation.AnimalViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: AnimalViewModel by viewModels { AnimalViewModel.factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiriusTheme {
                AnimalScreens()
                //LandingPage()
                //MyComposable(viewModel = viewModel)
            }
        }
    }
}