
package com.example.larelar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaTarefas(
    tarefas: List<Tarefa>,
    onVoltar: () -> Unit,
    onConcluir: (Int, Boolean) -> Unit
) {

    val pendentes = tarefas.count { !it.concluida }
    val concluidas = tarefas.count { it.concluida }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Bege)
            .padding(20.dp)
    ) {

        Text(
            text = "LareLar",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Verde
        )

        Text(
            text = "Minhas tarefas",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Marrom
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Organize as atividades da sua casa.",
            fontSize = 15.sp,
            color = Marrom
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = VerdeClaro
                )
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$pendentes",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Verde
                    )

                    Text("Pendentes", color = Marrom)
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                colors = CardDefaults.cardColors(
                    containerColor = Branco
                )
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "$concluidas",
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Verde
                    )

                    Text("Concluídas", color = Marrom)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            itemsIndexed(tarefas) { indice, tarefa ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = Branco
                    ),
                    shape = RoundedCornerShape(14.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Checkbox(
                            checked = tarefa.concluida,
                            onCheckedChange = { marcada ->
                                onConcluir(indice, marcada)
                            }
                        )

                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 6.dp)
                        ) {

                            Text(
                                text = tarefa.nome,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                color = Marrom
                            )

                            Text(
                                text = "Responsável: ${tarefa.responsavel}",
                                fontSize = 14.sp,
                                color = Marrom
                            )

                            Text(
                                text = if (tarefa.concluida)
                                    "Concluída" else "Pendente",
                                fontSize = 13.sp,
                                color = Verde
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onVoltar,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Verde
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Sair / Voltar ao login")
        }
    }
}
