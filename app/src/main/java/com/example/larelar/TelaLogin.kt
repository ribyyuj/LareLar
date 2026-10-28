
package com.example.larelar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelaLogin(
    onEntrar: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Bege)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "LareLar",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = Verde
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sua casa em harmonia!",
            fontSize = 18.sp,
            color = Marrom
        )

        Spacer(modifier = Modifier.height(28.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = Branco
            ),
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Text(
                    text = "Bem-vindo(a)!",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Marrom
                )

                Text(
                    text = "Entre para organizar as tarefas da sua casa.",
                    fontSize = 15.sp,
                    color = Marrom
                )

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("E-mail") },
                    placeholder = { Text("Digite seu e-mail") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                OutlinedTextField(
                    value = senha,
                    onValueChange = { senha = it },
                    label = { Text("Senha") },
                    placeholder = { Text("Digite sua senha") },
                    visualTransformation =
                        PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp)
                )

                Button(
                    onClick = onEntrar,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Verde
                    ),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Entrar",
                        fontSize = 16.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Organização e cuidado em cada detalhe.",
            fontSize = 13.sp,
            color = Marrom
        )
    }
}
