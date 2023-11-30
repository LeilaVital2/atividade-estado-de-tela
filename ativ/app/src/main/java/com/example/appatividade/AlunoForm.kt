package com.example.appatividade

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlunoForm(onNavigate: (Screen) -> Unit) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var curso by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,

    ) {
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = idade,
            onValueChange = { idade = it },
            label = { Text("Idade") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = curso,
            onValueChange = { curso = it },
            label = { Text("Curso") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { onNavigate(Screen.Home) }) {
                Text("Voltar")
            }
            Button(
                onClick = {
                    // Salvar os dados (não implementado neste exemplo)
                    // Pode ser feita a validação dos dados aqui antes de salvar
                    // Exemplo: if (nome.isNotEmpty() && idade.isNotEmpty() && curso.isNotEmpty()) { ... }
                    onNavigate(Screen.Home)
                }
            ) {
                Text("Cadastrar")
            }
        }
    }
}

@Preview
@Composable
fun AlunoFormPreview() {
    AlunoForm(onNavigate = {})
}
