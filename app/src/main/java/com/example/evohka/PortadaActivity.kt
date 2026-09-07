package com.example.evohka

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.evohka.ui.theme.EvohkaTheme
import kotlinx.coroutines.delay

class PortadaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EvohkaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaPortada(modifier = Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaPortada(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(2000)
        context.startActivity(Intent(context, LoginActivity::class.java))
        (context as? ComponentActivity)?.finish()
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "EVOHKA", style = MaterialTheme.typography.headlineLarge)
        Text(text = "Encuentra tu próximo hogar", style = MaterialTheme.typography.bodyMedium)
    }
}