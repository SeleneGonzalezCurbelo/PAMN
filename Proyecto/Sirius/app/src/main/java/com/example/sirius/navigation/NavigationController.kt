package com.example.sirius.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sirius.view.components.NavigationActions
import com.example.sirius.view.components.NavigationContent

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationController (){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val navController = rememberNavController()
        println("navController")
        val navigateAction = remember(navController) {
            NavigationActions(navController)
        }
        println("navigateAction")


        val navBackStackEntry by navController.currentBackStackEntryAsState()
        println("navBackStackEntry")

        val selectedDestination = navBackStackEntry?.destination?.route ?: Routes.HOME
        println("antes de entrar en NavigationContent")
        NavigationContent(
            modifier = Modifier,
            navController = navController,
            selectedDestination = selectedDestination,
            navigateDestination = navigateAction::navigateTo
        )
    }
}