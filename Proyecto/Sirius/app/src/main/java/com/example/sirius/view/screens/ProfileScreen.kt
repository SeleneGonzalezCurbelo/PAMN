package com.example.sirius.view.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.sirius.R
import com.example.sirius.model.Animal
import com.example.sirius.navigation.Routes
import com.example.sirius.ui.theme.Gold
import com.example.sirius.ui.theme.Green1
import com.example.sirius.ui.theme.Orange
import com.example.sirius.viewmodel.AnimalViewModel
import com.example.sirius.viewmodel.UserViewModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ProfileScreen(navController: NavController,
                  userViewModel: UserViewModel,
                  animalViewModel: AnimalViewModel) {
    var isUsernameEditable by remember { mutableStateOf(false) }

    var user by remember { mutableStateOf(userViewModel.getAuthenticatedUser()) }
    var username by remember { mutableStateOf(user?.username ?: "") }
    var email by remember { mutableStateOf(user?.email ?: "") }
    var password by remember { mutableStateOf(user?.password ?: "") }
    println("aaaaa")
    println(user?.favorites)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.55f)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Image at the bottom
                Image(
                    painter = painterResource(id = R.drawable.user_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .border(1.dp, Gold)
                        .fillMaxWidth(0.40f) // 50% del ancho
                        .align(Alignment.CenterVertically)
                )

                // Row for user information
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f), // 50% del ancho
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    // User information on the right
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ProfileItem(
                            label = stringResource(id = R.string.username),
                            value = username,
                            onEditClick = {
                                isUsernameEditable = true
                            },
                            userViewModel = userViewModel
                        )
                        ProfileItem(label = stringResource(id = R.string.email), value = email)

                        // Change Password Button
                        ChangePasswordButton(
                            onClick = {
                                // Handle change password logic here
                            },
                        )
                        // Log Out Button
                        LogoutButton(
                            onLogoutClick = {
                                userViewModel.viewModelScope.launch {
                                    userViewModel.logout()
                                    navController.navigate(Routes.LOGIN)
                                }
                            }
                        )
                    }
                }
            }

            // Friends you like
            Text(
                text = "Friends you like",
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight(400),
                ),
                textAlign = TextAlign.Center,
            )

            // Ensure that favoritesString is not null before proceeding with UI
            user?.favorites?.let { nonNullFavoritesString ->
                val favoriteIds: List<Int> = nonNullFavoritesString
                    .split(",").mapNotNull { it.trim().toIntOrNull() }

                println("favoriteIds")
                println(favoriteIds)

                LazyColumn {
                    items(favoriteIds) { animalId ->
                        println("animalId")
                        println(animalId)
                        // Fetch animal by ID or use the existing object (whichever suits your use case)
                        val animalState by animalViewModel.getAnimalById(animalId)
                            .collectAsState(initial = null)
                        animalState?.let { AnimalCardGallery(it, navController) }
                    }
                }

            }
        }
    }
}

@Composable
fun AnimalCardGallery(animal: Animal,
                      navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Green1,
        ),
        border = BorderStroke(2.dp, Gold),
        shape = MaterialTheme.shapes.medium,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Imagen del animal
                val context = LocalContext.current
                val resourceName = animal.photoAnimal.substringAfterLast("/")
                val resourceId = context.resources.getIdentifier(
                    resourceName.replace(".jpg", ""), "drawable", context.packageName
                )
                if (resourceId != 0) {
                    val painter = painterResource(id = resourceId)
                    Image(
                        painter = painter,
                        contentDescription = animal.nameAnimal,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(shape = MaterialTheme.shapes.medium)
                            .background(MaterialTheme.colorScheme.background)
                    )
                }

                // Resto de la información del animal
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = animal.nameAnimal,
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 4.dp)
                    )

                    Text(
                        text = "Type: ${animal.breedAnimal}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Sex: ${animal.sexAnimal}",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Info: ${animal.shortInfoAnimal} years",
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                }
            }
            Button(
                onClick = {
                    navController.navigate(route = Routes.ANIMALINFO + "/" + animal.id)
                },
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(Orange)
            ) {
                Text(text = "Details")
            }
        }
    }
}


@Composable
fun ProfileItem(
    label: String,
    value: String,
    onEditClick: (() -> Unit)? = null,
    userViewModel: UserViewModel? = null) {
    var user by remember { mutableStateOf(userViewModel?.getAuthenticatedUser()) }
    var isEditing by remember { mutableStateOf(false) }
    var editedValue by remember { mutableStateOf(value) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = label,
                //            style = MaterialTheme.typography.labelLarge,
                //            color = MaterialTheme.colorScheme.primary
            )
            if (!isEditing && onEditClick != null) {
                // Mostrar el ícono de edición solo si no está en modo de edición y hay una acción de edición
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isEditing = true
                        onEditClick.invoke()
                    }
                )
            }

            if (isEditing) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = null,
                    modifier = Modifier.clickable {
                        isEditing = false
                        userViewModel?.viewModelScope?.launch {
                            user?.let { userViewModel.updateUserName(user = it, newUserName = editedValue) }
                        }
                    }
                )
            }

        }
        Spacer(modifier = Modifier.height(4.dp))
        if (isEditing) {
            OutlinedTextField(
                value = editedValue,
                onValueChange = {
                    editedValue = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Green1,
                    unfocusedBorderColor = Green1,
                )
            )
        } else {
            Text(
                text = editedValue,
                modifier = Modifier.clickable {
                    isEditing = true
                }
            )
        }
    }
}

@Composable
fun LogoutButton(onLogoutClick: () -> Unit) {
    IconButton(
        onClick = { onLogoutClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(imageVector = Icons.Outlined.Lock, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Logout")
        }
    }
}

@Composable
fun ChangePasswordButton(onClick: () -> Unit) {
    var isChangePasswordVisible by remember { mutableStateOf(true) }
    var newPassword by remember { mutableStateOf("") }
    if (isChangePasswordVisible) {
        Button(
            onClick = {
                // Handle button click logic
                onClick()
                // Cambiar el estado para hacer invisible el botón
                isChangePasswordVisible = false
            }
        ) {
            Text("Change Password")
        }
    } else {
        // Mostrar el campo de texto para cambiar la contraseña
        OutlinedTextField(
            value = newPassword,
            onValueChange = {
                newPassword = it
            },
            label = { Text("New Password") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

    }
}