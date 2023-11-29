package com.example.sirius.view.screens

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sirius.R
import com.example.sirius.navigation.Routes
import com.example.sirius.viewmodel.navigation.ContactsViewModel

@Composable
fun DonationsScreen(navController: NavHostController) {
    val viewModelContacts = remember { ContactsViewModel() }

    Log.d("DonationsScreen", "DonationsScreen recomposed")


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        item {
            DonationsText(
                textResourceId = R.string.donationsTitle,
                style = MaterialTheme.typography.headlineSmall
            )
        }
        item {
            DonationsText(
                textResourceId = R.string.donationsText,
                style = MaterialTheme.typography.bodyLarge
            )
        }
        item {
            Spacer(modifier = Modifier.height(10.dp)) // Ajusta la altura del Spacer según sea necesario
        }
        item {
            DonationButton(
                onClick = {
                    navController.navigate(route = Routes.LOADING + "/" + 1)
                },
                imageResIdLeft = R.drawable.paypal_logo,
                buttonText = "Donate with PayPal"
            )
        }

        item {
            DonationButton(
                onClick = {
                    navController.navigate(route = Routes.LOADING + "/" + 1)
                },
                imageResIdLeft = R.drawable.mastercard_logo,
                buttonText = "Donate with Debit or Credit Card"
            )
        }
        item {
            DonationButton(
                onClick = {
                    navController.navigate(route = Routes.LOADING + "/" + 1)
                },
                imageResIdLeft = R.drawable.bizum_logo,
                buttonText = "Donate with Bizum"
            )
        }
        item {
            Spacer(modifier = Modifier.height(5.dp)) // Ajusta la altura del Spacer según sea necesario
        }
        item {
            DonationsText(
                textResourceId = R.string.donationsEnd,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Composable
fun DonationButton(
    onClick: () -> Unit,
    imageResIdLeft: Int,
    buttonText: String
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp) // Establece una altura mínima
            .wrapContentHeight(Alignment.CenterVertically) // Hace que la altura se ajuste al contenido
            .padding(bottom = 16.dp),
        colors = ButtonDefaults.buttonColors(Color(0xFFFFA500))
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize(Alignment.Center)
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            DonationsImage(imageResIdLeft)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                buttonText,
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun DonationsImage(imageId: Int, size: Dp = 40.dp) {
    Image(
        painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
    )
}

@Composable
fun DonationsText(@StringRes textResourceId: Int, style: androidx.compose.ui.text.TextStyle) {
    Text(
        text = stringResource(id = textResourceId),
        style = style,
        color = Color.Black
    )
}

//@Preview
//@Composable
//fun DonationsScreenPreview() {
//    SiriusTheme {
//        Surface {
//            DonationsScreen()
//        }
//    }
//}