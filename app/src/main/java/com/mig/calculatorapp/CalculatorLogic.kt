package com.mig.calculatorapp

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

class CalculatorLogic {

    private val _currentInput = mutableStateOf("") // Remove 'by' delegate
    val currentInput: State<String> = _currentInput // Directly use _currentInput
    private var currentOperation: String? = null
    private var previousNumber: Double? = null

    fun onNumberClicked(number: String) {
        _currentInput.value += number // Update the state
    }

    fun onOperationClicked(operation: String) {
        if (_currentInput.value.isNotEmpty()) {
            previousNumber = _currentInput.value.toDoubleOrNull()
            currentOperation = operation
            _currentInput.value = "" // Update _currentInput.value
        }
    }

    fun onEqualsClicked(): Double? {
        val currentNumber = _currentInput.value.toDoubleOrNull()
        if (previousNumber != null && currentNumber != null && currentOperation != null) {
            return when (currentOperation) {
                "+" -> previousNumber!! + currentNumber
                "-" -> previousNumber!! - currentNumber
                "*" -> previousNumber!! * currentNumber
                "/" -> previousNumber!! / currentNumber
                else -> null
            }
        }
        return null
    }

    fun clear() {
        _currentInput.value = "" // Update _currentInput.value
        currentOperation = null
        previousNumber = null
    }

    fun getCurrentInput(): String {
        return _currentInput.value // Access the state value
    }
}