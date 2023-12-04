package com.adventofcode.solution.day4

import kotlin.math.pow

private const val BASE_POWER: Double = 2.0
data class Card(val cardNumber: Int, val winningNumbers: Set<Int>, val cardNumbers: Set<Int>) {

    fun result(): Int = BASE_POWER.pow(matches() - 1).toInt()

    fun matches(): Int = winningNumbers.count { cardNumbers.contains(it) }


}