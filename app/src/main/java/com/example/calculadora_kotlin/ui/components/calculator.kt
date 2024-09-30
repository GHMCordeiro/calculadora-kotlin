package com.example.calculadora_kotlin.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Calculator() {
    var number1 by remember { mutableStateOf("") }
    var number2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Input fields
        BasicTextField(
            value = number1,
            onValueChange = { number1 = it },
            modifier = Modifier.padding(8.dp)
        )

        BasicTextField(
            value = number2,
            onValueChange = { number2 = it },
            modifier = Modifier.padding(8.dp)
        )

        // Operation buttons
        Row {
            Button(onClick = { operation = "+" }) { Text("+") }
            Button(onClick = { operation = "-" }) { Text("-") }
            Button(onClick = { operation = "*" }) { Text("*") }
            Button(onClick = { operation = "/" }) { Text("/") }
        }

        // Calculate button
        Button(onClick = {
            val num1 = number1.toDoubleOrNull()
            val num2 = number2.toDoubleOrNull()
            result = when (operation) {
                "+" -> (num1?.plus(num2 ?: 0.0)).toString()
                "-" -> (num1?.minus(num2 ?: 0.0)).toString()
                "*" -> (num1?.times(num2 ?: 0.0)).toString()
                "/" -> if (num2 != 0.0) (num1?.div(num2!!)).toString() else "Error: Div/0"
                else -> "Select an operation"
            } ?: "Invalid input"
        }) {
            Text("Calculate")
        }

        // Result display
        Text(text = "Result: $result", modifier = Modifier.padding(16.dp))
    }
}