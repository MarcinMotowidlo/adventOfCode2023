package com.adventofcode.solution.day9

class Day9 {

    fun task1(input: List<String>): Long {
        return parseInput(input)
            .sumOf { it.last() + extrapolate(it, finish = true) }
    }

    fun task2(input: List<String>): Long {
        return parseInput(input)
            .sumOf { it.first() - extrapolate(entry = it, finish = false) }
    }

    private fun extrapolate(entry: List<Long>, finish: Boolean): Long {
        val windowed = entry.windowed(size = 2, step = 1)
            .map { (first, second) ->
                second - first
            }

        if (windowed.all { it == 0L }) {
            return 0
        }

        return if (finish) {
            extrapolate(windowed, finish) + windowed.last()
        } else {
            windowed.first() - extrapolate(windowed, finish)
        }
    }

    private fun parseInput(input: List<String>) =
        input
            .map { it ->
                it.split(' ')
                    .map { it.toLong() }
            }
}
