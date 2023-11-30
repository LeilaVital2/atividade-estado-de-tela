package com.example.appatividade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.appatividade.ui.theme.AppAtividadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppAtividadeTheme {
                // Use the theme here
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Home) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.app_name)) },
                backgroundColor = MaterialTheme.colorScheme.primary
            )
        },
        content = {
            when (currentScreen) {
                Screen.Home -> HomeScreen { currentScreen = it }
                Screen.AlunoForm -> AlunoForm { currentScreen = it }
                Screen.CursoForm -> CursoForm { currentScreen = it }
            }
        }
    )
}

@Composable
fun HomeScreen(onNavigate: (Screen) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "Cadastrar Aluno",
            modifier = Modifier
                .padding(16.dp)
                .clickable { onNavigate(Screen.AlunoForm) }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Icon(
            imageVector = Icons.Default.MenuBook,
            contentDescription = "Cadastrar Curso",
            modifier = Modifier
                .padding(16.dp)
                .clickable { onNavigate(Screen.CursoForm) }
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun AlunoForm(onNavigate: (Screen) -> Unit) {
    var nome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = idade.toString(),
            onValueChange = { idade = it.toIntOrNull() ?: 0 },
            label = { Text("Idade") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Aqui você pode salvar os dados do aluno, por exemplo, em um banco de dados
                // ou realizar outras ações necessárias.
                onNavigate(Screen.Home)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Salvar Aluno")
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun CursoForm(onNavigate: (Screen) -> Unit) {
    var nomeCurso by remember { mutableStateOf("") }
    var descricaoCurso by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nomeCurso,
            onValueChange = { nomeCurso = it },
            label = { Text("Nome do Curso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = descricaoCurso,
            onValueChange = { descricaoCurso = it },
            label = { Text("Descrição do Curso") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                // Aqui você pode salvar os dados do curso, por exemplo, em um banco de dados
                // ou realizar outras ações necessárias.
                onNavigate(Screen.Home)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Salvar Curso")
        }
    }
}

enum class Screen {
    Home, AlunoForm, CursoForm
}
