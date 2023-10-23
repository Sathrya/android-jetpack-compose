package com.example.compose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                var name by remember {
                    mutableStateOf("")
                }
                val names by remember {
                    mutableStateOf(mutableListOf<String>())
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = name,
                            onValueChange = { text ->
                            name = text
                        } ,
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            names.add(name)
                            name = ""
                        }) {
                            Text(text = "Add")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            names.removeAt(2)
                            Log.d("List",names.toString())
                        }) {
                            Text(text = "Delete All")
                        }
                    }
                    displayNames(names = names)
                }
            }
        }
    }


    @Composable
    fun displayNames(names:List<String>,modifier: Modifier = Modifier) {
        LazyColumn {
            items(names) { currentName ->
                Text(text = currentName,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp))
                Divider()
            }
        }
    
    }
}
