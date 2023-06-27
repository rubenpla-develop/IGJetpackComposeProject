package com.rubenpla.igjetpackcomposeproject

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Header(Modifier.align(Alignment.TopEnd))
        Body(modifier = Modifier.align(Alignment.Center))
    }

    //Body()
    //Footer()
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "Close Screen",
        modifier = modifier.clickable { activity.finish() })
}

@Composable
fun Body(modifier: Modifier) {
    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var isLoginEnabled by rememberSaveable {
        mutableStateOf(false)
    }

    Column(modifier = modifier) {
        ImageLogo(Modifier.align(Alignment.CenterHorizontally))
        Spacer(
            modifier = Modifier
                .size(16.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
        )
        EmailTextField(email) { currentText -> email = currentText }
        Spacer(
            modifier = Modifier
                .size(8.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
        )
        PasswordTextField(password) { currentText -> password = currentText }
        Spacer(
            modifier = Modifier
                .size(8.dp)
                .fillMaxWidth()
                .background(Color.DarkGray)
        )
        ForgotPassword(Modifier.align(Alignment.End))
        Spacer(
            modifier = Modifier
                .size(16.dp)
                .background(Color.DarkGray)
        )
        LoginButton(isLoginEnabled)
        Spacer(
            modifier = Modifier
                .size(16.dp)
                .background(Color.DarkGray)
        )
        LoginDivider()
        Spacer(
            modifier = Modifier
                .size(32.dp)
                .background(Color.DarkGray)
        )
        SocialLogin()
    }
}

@Composable
fun SocialLogin() {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fb),
            contentDescription = "Social login Facebook",
            modifier = Modifier.size(16.dp)
        )
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "Continue as Dwayne Johnson",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4EA8E9)
        )
    }
}

@Composable
fun LoginDivider() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
        Text(
            text = "OR",
            modifier = Modifier.padding(start = 18.dp, end = 18.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFFB5B5B5)
        )
        Divider(
            Modifier
                .background(Color(0xFFF9F9F9))
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(loginEnabled: Boolean) {
    Button(onClick = { /*TODO*/ }, enabled = loginEnabled, modifier = Modifier.fillMaxWidth()) {
        Text(text = "Log In")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        modifier = modifier,
        text = "Forgot Password",
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(email: String, onTextChanged: (String) -> Unit) {
    TextField(value = email, onValueChange = { onTextChanged(it) }, Modifier.fillMaxWidth())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(password: String, onTextChanged: (String) -> Unit) {
    TextField(value = password, onValueChange = { onTextChanged(it) }, Modifier.fillMaxWidth())

}

@Composable
fun ImageLogo(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.insta),
        contentDescription = "Insta Logo"
    )
}


@Composable
fun Footer() {

}
