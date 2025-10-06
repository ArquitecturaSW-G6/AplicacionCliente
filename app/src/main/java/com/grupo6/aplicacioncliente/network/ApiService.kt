package com.grupo6.aplicacioncliente.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
data class TurnoRequest(
    val nombre: String,
    val servicio: String,
    val hora: String
)

interface ApiService {
    @POST("turno")
    fun crearTurno(@Body request: TurnoRequest): Call<Void>
}
