package com.example.evohka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.evohka.ui.theme.EvohkaTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EvohkaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaLogin(modifier = Modifier.fillMaxSize().padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaLogin(modifier: Modifier = Modifier) {
    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mensaje by remember { mutableStateOf("") }
    var intentos by remember { mutableStateOf(0) }
    var habilitado by remember { mutableStateOf(true) }
    val maxIntentos = 3

    val usuariosValidos = mapOf(
        "admin" to "1234",
        "juan" to "clave123",
        "maria" to "evohka2026"
    )

    Column(
        modifier = modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_evohka),
            contentDescription = "Logo EVOHKA",
            modifier = Modifier.size(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Iniciar sesión", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") },
            enabled = habilitado,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            enabled = habilitado,
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                if (usuariosValidos[usuario] == password) {
                    mensaje = "Bienvenido, $usuario"
                } else {
                    intentos++
                    val restantes = maxIntentos - intentos
                    if (restantes > 0) {
                        mensaje = "Usuario o contraseña incorrectos. Intentos restantes: $restantes"
                    } else {
                        mensaje = "Has superado el número máximo de intentos."
                        habilitado = false
                    }
                }
            },
            enabled = habilitado,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = mensaje, color = MaterialTheme.colorScheme.error)
    }
}