package com.example.sirius

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sirius.ui.theme.SiriusTheme
import com.example.sirius.view.components.NavigationActions
import com.example.sirius.view.components.NavigationContent
import com.example.sirius.viewmodel.navigation.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SiriusTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val navigateAction = remember(navController) {
                        NavigationActions(navController)
                    }

                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val selectedDestination = navBackStackEntry?.destination?.route ?: Routes.HOME

                    NavigationContent(
                        navController = navController,
                        selectedDestination = selectedDestination,
                        navigateDestination = navigateAction::navigateTo
                    )
                }
            }
        }
    }
}