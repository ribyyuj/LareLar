
package com.example.larelar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {

                val navController = rememberNavController()

                val tarefas = remember {
                    mutableStateListOf(
                        Tarefa("Lavar a louça", "Ana", false),
                        Tarefa("Arrumar o quarto", "Lucas", false),
                        Tarefa("Tirar o lixo", "Ana", true),
                        Tarefa("Varrer a casa", "Lucas", false),
                        Tarefa("Organizar a cozinha", "Lucas", false)
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Bege
                ) {

                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {

                        composable("login") {
                            TelaLogin(
                                onEntrar = {
                                    navController.navigate("tarefas")
                                }
                            )
                        }

                        composable("tarefas") {
                            TelaTarefas(
                                tarefas = tarefas,
                                onVoltar = {
                                    navController.popBackStack()
                                },
                                onConcluir = { indice, concluida ->
                                    tarefas[indice] =
                                        tarefas[indice].copy(
                                            concluida = concluida
                                        )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
