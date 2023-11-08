package com.example.sirius.viewmodel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.example.sirius.R

@Composable
fun createDestination(route: String, selectedIcon: Int, iconTextId: Int): Destinations {
    return Destinations(
        route = route,
        selectedIcon = selectedIcon, // Aquí se espera un Int
        iconTextId = iconTextId,
    )
}

@Composable
fun createDestinations(): List<Destinations> {
    return listOf(

//        createDestination(Routes.ANIMALS, R.drawable.animals_icon, R.string.animals),
//        createDestination(Routes.DONATIONS, R.drawable.donations_icons, R.string.donations),
//        createDestination(Routes.ABOUTUS, R.drawable.sirius_no_name, R.string.aboutUs),
        Destinations(
            route = Routes.HOME,
            selectedIcon = R.drawable.home_icon_,
            iconTextId = R.string.home,
        ),
        Destinations(
            route = Routes.ANIMALS,
            selectedIcon = R.drawable.animal_icon_,
            iconTextId = R.string.animals,
        ),
        Destinations(
            route = Routes.DONATIONS,
            selectedIcon = R.drawable.donation_icon_,
            iconTextId = R.string.donations,
        ),
        Destinations(
            route = Routes.ABOUTUS,
            selectedIcon = R.drawable.about_us_icon_,
            iconTextId = R.string.aboutUs,
        ),
    )
}

data class Destinations(
    val route: String,
    val selectedIcon: Int,
    val iconTextId: Int
)


object Routes {
    const val HOME = "home"
    const val ANIMALS = "animals"
    const val DONATIONS = "donations"
    const val ABOUTUS = "about us"
}