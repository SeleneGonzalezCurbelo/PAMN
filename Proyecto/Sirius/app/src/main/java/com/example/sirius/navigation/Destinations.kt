package com.example.sirius.navigation

import androidx.compose.runtime.Composable
import com.example.sirius.R

@Composable
fun createDestination(route: String, selectedIcon: Int, iconTextId: Int): Destinations {
    return Destinations(
        route = route,
        selectedIcon = selectedIcon,
        unselectedIcon = selectedIcon,
        iconTextId = iconTextId,
    )
}

@Composable
fun createDestinations(): List<Destinations> {
    return listOf(
        createDestination(Routes.HOME, R.drawable.home_icon_, R.string.home),
        createDestination(Routes.ANIMALS, R.drawable.animal_icon_, R.string.animals),
        createDestination(Routes.DONATIONS, R.drawable.donation_icon_, R.string.donations),
        createDestination(Routes.ABOUTUS, R.drawable.about_us_icon_, R.string.aboutUs),
    )
}

data class Destinations(
    val route: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val iconTextId: Int
)

object Routes {
    const val HOME = "home"
    const val ANIMALS = "animals"
    const val DONATIONS = "donations"
    const val ABOUTUS = "about us"
    const val ANIMALINFO = "animal info"
}