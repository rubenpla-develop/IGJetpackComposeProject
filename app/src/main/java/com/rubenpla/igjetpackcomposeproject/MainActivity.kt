package com.rubenpla.igjetpackcomposeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.rubenpla.igjetpackcomposeproject.login.LoginViewModel
import com.rubenpla.igjetpackcomposeproject.ui.theme.IGJetpackComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IGJetpackComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginScreen(LoginViewModel())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(name = "PREVIEW 1",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 33,
    device = Devices.PIXEL_3A_XL)
@Composable
fun GreetingPreview() {
    IGJetpackComposeProjectTheme {
        LoginScreen(LoginViewModel())
    }
}