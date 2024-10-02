package com.mig.calculatorapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import com.mig.calculatorapp.ui.theme.components.CalcButton
import kotlinx.coroutines.launch

@Preview
@Composable
fun CalculatorScreen(modifier: Modifier = Modifier){

    val calculatorLogic = remember { CalculatorLogic() }
    var result by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 20.dp)
                .fillMaxWidth()
                .weight(2f),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = result ?: calculatorLogic.currentInput.value,
                color = Color.Black,
                fontSize = 100.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "CE", onClick = { calculatorLogic.clear(); result = null }, isDel = true)
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "C", onClick = { calculatorLogic.clear(); result = null }, isDel = true)
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "⌫", onClick = { calculatorLogic.clear(); result = null }, isDel = true)
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "÷", onClick = { calculatorLogic.onOperationClicked("/") }, isOperation = true)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "7", onClick = { calculatorLogic.onNumberClicked("7") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "8", onClick = { calculatorLogic.onNumberClicked("8") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "9", onClick = { calculatorLogic.onNumberClicked("9") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "x", onClick = { calculatorLogic.onOperationClicked("*") }, isOperation = true)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "4", onClick = { calculatorLogic.onNumberClicked("4") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "5", onClick = { calculatorLogic.onNumberClicked("5") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "6", onClick = { calculatorLogic.onNumberClicked("6") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "-", onClick = { calculatorLogic.onOperationClicked("-") }, isOperation = true)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "1", onClick = { calculatorLogic.onNumberClicked("1") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "2", onClick = { calculatorLogic.onNumberClicked("2") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "3", onClick = { calculatorLogic.onNumberClicked("3") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "+", onClick = { calculatorLogic.onOperationClicked("+") }, isOperation = true)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "+/-", onClick = { })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "0", onClick = { calculatorLogic.onNumberClicked("0") })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = ".", onClick = { })
            CalcButton( modifier = Modifier.weight(1f).aspectRatio(1f), label = "=", onClick = { coroutineScope.launch{ result = calculatorLogic.onEqualsClicked() }}, isOperation = true)
        }
    }
}