package com.grupo6.aplicacioncliente

import android.content.Context
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.grupo6.aplicacioncliente.network.ApiClient
import com.grupo6.aplicacioncliente.network.TurnoRequest
import com.grupo6.aplicacioncliente.ui.theme.AplicacionClienteTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
fun crearTurno(context: Context, nombre: String) {
    // ⚡ Aquí pones valores simulados por ahora
    val turno = TurnoRequest(
        nombre = nombre,
        servicio = "Consulta", // puedes hacer otro TextField si quieres
        hora = "10:30"         // o tomar la hora del sistema
    )

    val call = ApiClient.instance.crearTurno(turno)
    call.enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>, response: Response<Void>) {
            if (response.isSuccessful) {
                Toast.makeText(context, "Turno solicitado para $nombre", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Error: ${response.code()}", Toast.LENGTH_SHORT).show()
            }
        }

        override fun onFailure(call: Call<Void>, t: Throwable) {
            Toast.makeText(context, "Fallo de red: ${t.message}", Toast.LENGTH_SHORT).show()
        }
    })
}


@Composable
fun VistaSolicitarTurno(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var nombre by remember { mutableStateOf("") }

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
            text = "Ingrese su nombre y presione el botón para solicitar turno",
            style = MaterialTheme.typography.bodyLarge
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                crearTurno(context, nombre)
                nombre = "" // limpiar el campo después de enviar
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = nombre.isNotBlank() // desactiva si está vacío
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