package com.example.namanim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.namanim.ui.theme.NamaNIMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NamaNIMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp)) {

        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Masukkan Nama") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TextField(
            value = nim,
            onValueChange = { nim = it },
            label = { Text("Masukkan NIM") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(onClick = { result = "Nama: $nama \nNIM: $nim" }) {
            Text("Tampilkan")
        }

        if (result.isNotEmpty()) {
            Text(
                text = result,
                modifier = Modifier.padding(top = 16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    NamaNIMTheme {
        MainScreen()
    }
}
