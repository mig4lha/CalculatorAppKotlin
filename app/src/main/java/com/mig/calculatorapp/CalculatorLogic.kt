package com.mig.calculatorapp

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import kotlin.text.toDoubleOrNull

class CalculatorLogic {

    private val _currentInput = mutableStateOf("0")
    val currentInput: State<String> = _currentInput
    private var currentOperation: String? = null
    private var previousNumber: Double? = null
    private var previousResult: Double? = null

    fun onNumberClicked(number: String) {
        if (_currentInput.value == "0" && number != ".") {
            _currentInput.value = ""
        }
        if (number == "." && _currentInput.value.contains(".")) {
            return
        }
        _currentInput.value += number
    }

    fun onOperationClicked(operation: String) {
        if (_currentInput.value.isNotEmpty()) {
            previousNumber = if (previousResult != null) {
                previousResult
            } else {
                _currentInput.value.toDoubleOrNull()
            }
            currentOperation = operation
            previousResult = null
            _currentInput.value = ""
        }
    }

    fun onEqualsClicked(): String {
        val currentNumber = _currentInput.value.toDoubleOrNull()
        if (previousNumber != null && currentNumber != null && currentOperation != null) {
            val result = when (currentOperation) {
                "+" -> previousNumber!! + currentNumber
                "-" -> previousNumber!! - currentNumber
                "*" -> previousNumber!! * currentNumber
                "/" -> previousNumber!! / currentNumber
                else -> null
            }
            if (result != null) {
                previousResult = result
                return if (result % 1 == 0.0) {
                    result.toInt().toString()
                } else {
                    String.format("%.3f", result)
                }
            }
        }
        return _currentInput.value
    }

    fun clear() {
        _currentInput.value = "0"
        currentOperation = null
        previousNumber = null
        previousResult = null
    }

    fun getCurrentInput(): String {
        return _currentInput.value
    }
}