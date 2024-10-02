package com.mig.calculatorapp.ui.theme.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.unit.dp
import com.mig.calculatorapp.ui.theme.ButtonNumbers
import com.mig.calculatorapp.ui.theme.ButtonOps
import com.mig.calculatorapp.ui.theme.ButtonsDels

@Composable
fun CalcButton(
    modifier: Modifier = Modifier,
    label: String = "",
    isOperation:Boolean = false,
    isDel:Boolean = false,
    onClick:(String)->Unit={}
){
    Button(
        modifier = modifier,
        colors = if(isDel)
                ButtonDefaults.buttonColors(ButtonsDels)
            else if(isOperation)
                ButtonDefaults.buttonColors(ButtonOps)
            else ButtonDefaults.buttonColors(ButtonNumbers),
        onClick = {
            onClick(label)
        }) {
        Text(text = label,
            style = MaterialTheme.typography.bodyLarge)
    }
}