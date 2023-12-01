package com.adventofcode.solution.day1

class Day1 {
    fun task1(input: List<String>): Int {
        return input.sumOf { subSum(firstLastOnlyDigits(it.toCharArray())) }
    }

    fun task2(input: List<String>): Int {
        return input.sumOf { subSum(firstLast(it)) }
    }

    private fun subSum(pair: Pair<Int, Int>) = (pair.first.toString() + pair.second.toString()).toInt()

    private fun firstLastOnlyDigits(input: CharArray): Pair<Int, Int> {
        var first: Int? = null
        var last: Int? = null
        input.forEach {
            if (it.isDigit()) {
                if (first == null) {
                    first = it.digitToInt()
                }
                last = it.digitToInt()
            }
        }
        return Pair(first!!, last!!)
    }

    private fun firstLast(input: String): Pair<Int, Int> {
        return Pair(input.indices.map { index -> findFirst(input, index) }.filterNotNull().first(),
            input.indices.firstNotNullOf { index -> findLast(input, index) }
        )
    }

    private fun findFirst(input: String, index: Int): Int? {
        if (input[index].isDigit()) {
            return input[index].digitToInt()
        } else {
            val foundDigit: Digits? = Digits.entries.firstOrNull { input.substring(index).startsWith(it.text) }
            if (foundDigit != null) {
                return foundDigit.number
            }
        }
        return null
    }

    private fun findLast(input: String, index: Int): Int? {
        val maxIndex = input.length - 1
        if (input[maxIndex - index].isDigit()) {
            return input[maxIndex - index].digitToInt()
        } else {
            val foundDigit: Digits? =
                Digits.entries.firstOrNull { input.substring(maxIndex - index).startsWith(it.text) }
            if (foundDigit != null) {
                return foundDigit.number
            }
        }
        return null
    }

    private enum class Digits(val text: String, val number: Int) {
        ONE("one", 1),
        TWO("two", 2),
        THREE("three", 3),
        FOUR("four", 4),
        FIVE("five", 5),
        SIX("six", 6),
        SEVEN("seven", 7),
        EIGHT("eight", 8),
        NINE("nine", 9)
    }
}
