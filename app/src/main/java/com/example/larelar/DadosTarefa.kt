
package com.example.larelar

import androidx.compose.ui.graphics.Color

// Paleta de cores do LareLar
val Bege = Color(0xFFFFF7E8)
val Verde = Color(0xFF667D65)
val VerdeClaro = Color(0xFFE4EBDD)
val Marrom = Color(0xFF493B32)
val Branco = Color(0xFFFFFFFF)

data class Tarefa(
    val nome: String,
    val responsavel: String,
    val concluida: Boolean
)
