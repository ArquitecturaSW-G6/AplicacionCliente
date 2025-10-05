package com.grupo6.aplicacioncliente

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grupo6.aplicacioncliente.ui.theme.AplicacionClienteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacionClienteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    VistaSolicitarTurno(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
fun crearTurno(context: android.content.Context) {
    // Aquí pondrías la lógica para consumir el servicio REST o enviar mensaje al backend.
    Toast.makeText(context, "Turno solicitado correctamente", Toast.LENGTH_SHORT).show()
}

@Composable
fun VistaSolicitarTurno(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenido",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Presiona el botón para solicitar turno",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { crearTurno(context) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Solicitar turno")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaSolicitarTurnoPreview() {
    AplicacionClienteTheme {

    }
}