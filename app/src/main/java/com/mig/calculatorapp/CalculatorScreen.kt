package com.mig.calculatorapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CalculatorScreen(modifier: Modifier = Modifier){
    Column{
        Text(text = "0")
        Row{
            Button(onClick={}) {
                Text(text = "7")
            }
            Button(onClick = {}) {
                Text(text = "8")
            }
        }
    }
}