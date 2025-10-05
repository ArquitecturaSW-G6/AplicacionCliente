package com.grupo6.aplicacioncliente.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

data class TurnoRequest(val nombre: String)

interface ApiService {
    @POST("turnos")
    fun crearTurno(@Body request: TurnoRequest): Call<Void>
}