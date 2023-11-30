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
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CursoForm(onNavigate: (Screen) -> Unit) {
    var nomeCurso by remember { mutableStateOf("") }
    var cargaHoraria by remember { mutableStateOf("") }
    var professor by remember { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Arrangement.Center
    ) {
        TextField(
            value = nomeCurso,
            onValueChange = { nomeCurso = it },
            label = { Text("Nome do Curso") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = cargaHoraria,
            onValueChange = { cargaHoraria = it },
            label = { Text("Carga Horária") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = professor,
            onValueChange = { professor = it },
            label = { Text("Professor") },
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
                    // Exemplo: if (nomeCurso.isNotEmpty() && cargaHoraria.isNotEmpty() && professor.isNotEmpty()) { ... }
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
fun CursoFormPreview() {
    CursoForm(onNavigate = {})
}
