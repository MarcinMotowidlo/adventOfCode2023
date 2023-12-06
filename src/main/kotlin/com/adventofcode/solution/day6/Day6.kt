package com.adventofcode.solution.day6

import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.sqrt

class Day6 {
    fun task1(input: List<String>): Long {

        val timeDistance: Pair<List<Long>, List<Long>> = parse(input)

        val alternatives: List<Int> = timeDistance.first.withIndex().map { (i, t) ->
            (0..<t).count { waitTime -> calculate(t, waitTime) > timeDistance.second[i] }
        }

        var result: Long = 1
        alternatives.forEach { result *= it }

        return result
    }


    fun task2(input: List<String>): Long {

        val timeDistance: Pair<Long, Long> = parseTask2(input)

        // T - race time
        // D - distance
        // function: f(x) = (T-x)x
        // condition: f(x) > D
        // (T-x)x > D -> (T-x)x - D > 0 -> - x^2 + Tx  - D > 0
        // main form: ax^2+bx+c=0
        // a = -1 ; b = T ; c = -1
        // delta = b^2−4ac

        // x1 = (-b - sqrt(delta)) / 2a
        // x1 = (-b + sqrt(delta)) / 2a

        // x1 = (T - sqrt(T^2-4D))/2
        // x2 = (T + sqrt(T^2-4D))/2

        val time = timeDistance.first
        val distance = timeDistance.second
        val x1 = (time - sqrt((time * time - 4 * distance).toDouble())) / 2
        val x2 = (time + sqrt((time * time - 4 * distance).toDouble())) / 2

        return (floor(x1.plus(1)).toLong()..ceil(x2.minus(1)).toLong()).count().toLong()
    }


    private fun parse(input: List<String>): Pair<List<Long>, List<Long>> {
        val time: List<Long> = input[0]
            .split("Time:")[1]
            .split(" ")
            .filter { it.isNotBlank() }
            .map { it.toLong() }.toList()

        val distance: List<Long> =
            input[1]
                .split("Distance:")[1]
                .split(" ")
                .filter { it.isNotBlank() }
                .map { it.toLong() }
                .toList()

        return Pair(time, distance)
    }

    private fun parseTask2(input: List<String>): Pair<Long, Long> {
        val time: Long = input[0]
            .split("Time:")[1]
            .split(" ")
            .filter { it.isNotBlank() }
            .joinToString(separator = "")
            .toLong()

        val distance: Long =
            input[1]
                .split("Distance:")[1]
                .split(" ")
                .filter { it.isNotBlank() }
                .joinToString(separator = "")
                .toLong()

        return Pair(time, distance)
    }

    private fun calculate(time: Long, waitTime: Long) = waitTime * (time - waitTime)
}
