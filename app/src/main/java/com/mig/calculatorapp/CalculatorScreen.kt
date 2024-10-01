package com.mig.calculatorapp

import androidx.activity.result.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import kotlinx.coroutines.launch

@Preview
@Composable
fun CalculatorScreen(modifier: Modifier = Modifier){

    val calculatorLogic = remember { CalculatorLogic() }
    var result by remember { mutableStateOf<Double?>(null) }
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = result?.toString() ?: calculatorLogic.currentInput.value,
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 20.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Right,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold

            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { }, modifier = Modifier.weight(2.08f)) {
                    Text(text = "💀❔")
                }
                Button(onClick = { calculatorLogic.clear(); result = null }, modifier = Modifier.weight(1f)) {
                    Text(text = "C")
                }
                Button(onClick = { }, modifier = Modifier.weight(1f)) {
                    Text(text = "⌫")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { }, modifier = Modifier.weight(1f)) {
                    Text(text = "1/x")
                }
                Button(onClick = { }, modifier = Modifier.weight(1f)) {
                    Text(text = "x²")
                }
                Button(onClick = { }, modifier = Modifier.weight(1f)) {
                    Text(text = "√x")
                }
                Button(onClick = { calculatorLogic.onOperationClicked("/") }, modifier = Modifier.weight(1f)) {
                    Text(text = "÷")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { calculatorLogic.onNumberClicked("7") }, modifier = Modifier.weight(1f)) {
                    Text(text = "7")
                }
                Button(onClick = { calculatorLogic.onNumberClicked("8") }, modifier = Modifier.weight(1f)) {
                    Text(text = "8")
                }
                Button(onClick = { calculatorLogic.onNumberClicked("9") }, modifier = Modifier.weight(1f)) {
                    Text(text = "9")
                }
                Button(onClick = { calculatorLogic.onOperationClicked("*") }, modifier = Modifier.weight(1f)) {
                    Text(text = "x")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { calculatorLogic.onNumberClicked("4") }, modifier = Modifier.weight(1f)) {
                    Text(text = "4")
                }
                Button(onClick = { calculatorLogic.onNumberClicked("5") }, modifier = Modifier.weight(1f)) {
                    Text(text = "5")
                }
                Button(onClick = { calculatorLogic.onNumberClicked("6") }, modifier = Modifier.weight(1f)) {
                    Text(text = "6")
                }
                Button(onClick = { calculatorLogic.onOperationClicked("-") }, modifier = Modifier.weight(1f)) {
                    Text(text = "-")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { calculatorLogic.onNumberClicked("1") }, modifier = Modifier.weight(1f)) {
                    Text(text = "1")
                }
                Button(onClick = { calculatorLogic.onNumberClicked("2") }, modifier = Modifier.weight(1f)) {
                    Text(text = "2")
                }
                Button(onClick = { calculatorLogic.onNumberClicked("3") }, modifier = Modifier.weight(1f)) {
                    Text(text = "3")
                }
                Button(onClick = { calculatorLogic.onOperationClicked("+") }, modifier = Modifier.weight(1f)) {
                    Text(text = "+")
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(onClick = { }, modifier = Modifier.weight(1f)) {
                    Text(text = "+/-")
                }
                Button(onClick = { }, modifier = Modifier.weight(1f)) {
                    Text(text = "0")
                }
                Button(onClick = { }, modifier = Modifier.weight(1f)) {
                    Text(text = ".")
                }
                Button(onClick = { coroutineScope.launch { // Use LaunchedEffect or rememberCoroutineScope
                    result = calculatorLogic.onEqualsClicked()
                } }, modifier = Modifier.weight(1f)) {
                    Text(text = "=")
                }
            }
        }
    }
}