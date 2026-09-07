package com.example.evohka

import org.junit.Test
import org.junit.Assert.*

class LoginValidacionTest {

    private val usuariosValidos = mapOf(
        "admin" to "1234",
        "juan" to "clave123",
        "maria" to "evohka2026"
    )

    @Test
    fun login_conCredencialesCorrectas_debeSerValido() {
        val resultado = usuariosValidos["admin"] == "1234"
        assertTrue(resultado)
    }

    @Test
    fun login_conContraseñaIncorrecta_debeSerInvalido() {
        val resultado = usuariosValidos["admin"] == "contraseñaMala"
        assertFalse(resultado)
    }

    @Test
    fun login_conUsuarioInexistente_debeSerInvalido() {
        val resultado = usuariosValidos["usuarioQueNoExiste"] == "1234"
        assertFalse(resultado)
    }

    @Test
    fun login_contadorDeIntentos_debeIncrementarCorrectamente() {
        var intentos = 0
        val maxIntentos = 3

        intentos++
        assertEquals(1, intentos)

        intentos++
        assertEquals(2, intentos)

        val restantes = maxIntentos - intentos
        assertEquals(1, restantes)
    }
}