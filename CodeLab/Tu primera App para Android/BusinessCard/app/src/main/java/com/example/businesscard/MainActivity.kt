package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    LogoNameAndTitle(
                        name = getString(R.string.name),
                        jobTitle = getString(R.string.job)
                    )
                    ContactInformation(
                        phoneNumber = getString(R.string.number),
                        socialMedia = getString(R.string.user),
                        email = getString(R.string.email)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
private fun BusinessCardPreview() {
    BusinessCardTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            LogoNameAndTitle(
                stringResource(R.string.name),
                stringResource(R.string.job)
            )
            ContactInformation(
                stringResource(R.string.number),
                stringResource(R.string.user),
                stringResource(R.string.email)
            )
        }
    }
}

@Composable
fun LogoNameAndTitle(
    name: String,
    jobTitle: String,
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F,
            modifier = Modifier.size(150.dp)
        )
        Text(
            text = name,
            fontSize = 30.sp,
            lineHeight = 40.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(2.dp))
        Text(
            text = jobTitle,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier,
            color = Color(0XFFBBDC9A)
        )
        Spacer(modifier = Modifier.height(50.dp))
    }
}

@Composable
fun ContactInformation(
    phoneNumber: String,
    socialMedia: String,
    email: String,
) {
    Column (
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(15.dp)
    ){
        Row (){
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Ícono de móvil",
                tint = Color.White
            )
            Text(
                text = phoneNumber,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
        Row (){
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "Ícono de user",
                tint = Color.White,
            )
            Text(
                text = socialMedia,
                color = Color.White,
            )
            Spacer(modifier = Modifier.height(5.dp))

        }
        Row (){
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Ícono de email",
                tint = Color.White
            )
            Text(
                text = email,
                color = Color.White,
            )
        }
    }
}