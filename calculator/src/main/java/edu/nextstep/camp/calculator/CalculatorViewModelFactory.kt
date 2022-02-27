package edu.nextstep.camp.calculator

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.github.dodobest.data.AppDatabase
import com.github.dodobest.data.CalculatorRepository
import com.github.dodobest.data.CalculatorRepositoryImpl
import com.github.dodobest.domain.Calculator
import com.github.dodobest.domain.Expression

class CalculatorViewModelFactory(private val context: Context, private val calculatorRepository: CalculatorRepositoryImpl) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            CalculatorViewModel::class.java -> createCalculatorViewModel()
            else -> throw IllegalArgumentException()
        } as T
    }

    private fun createCalculatorViewModel(): CalculatorViewModel {
        val expression = Expression()
        val calculator = Calculator()
        return CalculatorViewModel(expression, calculator, calculatorRepository)
    }
}