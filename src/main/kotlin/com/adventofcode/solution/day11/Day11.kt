package com.adventofcode.solution.day11

import java.awt.Point
import kotlin.math.abs

class Day11 {

    fun task1(input: Array<String>): Long {
        val expandableColumns = expandableColumns(input)
        val expandableRows = expandableRows(input)

        val expandedStars = expandedStars(input, expandableRows, expandableColumns, expandFactor = 2)
        val stairPairs = stairPairs(expandedStars)

        return stairPairs.sumOf { distance(it) }

    }

    fun task2(input: Array<String>, factor: Int): Long {
        val expandableColumns = expandableColumns(input)
        val expandableRows = expandableRows(input)

        val expandedStars = expandedStars(input, expandableRows, expandableColumns, factor)
        val stairPairs = stairPairs(expandedStars)

        return stairPairs.sumOf { distance(it) }

    }


    private fun expandableRows(input: Array<String>): List<Int> = input.mapIndexedNotNull { index, row ->
        if (row.all { it == '.' }) {
            index
        } else {
            null
        }
    }

    private fun expandableColumns(input: Array<String>): List<Int> = input.mapIndexedNotNull { rowIndex, _ ->
        if (input.indices.map { columnIndex -> input[columnIndex][rowIndex] }.all { it == '.' }) {
            rowIndex
        } else {
            null
        }
    }

    private fun stairPairs(stars: List<Point>): List<Pair<Point, Point>> {
        return stars.mapIndexed { index, p1 ->
            stars.subList(index + 1, stars.size)
                .map { p2 -> Pair(p1, p2) }
        }.flatten()
    }

    private fun distance(stars: Pair<Point, Point>): Long =
        (abs(stars.first.x - stars.second.x) + abs(stars.first.y - stars.second.y)).toLong()

    private fun expandedStars(
        input: Array<String>,
        expandableRows: List<Int>,
        expandableColumns: List<Int>,
        expandFactor: Int = 2
    ): List<Point> {
        val originalStars = mutableListOf<Point>()
        val stars = mutableListOf<Point>()
        var rowOffset = 0


        input.forEachIndexed { i, row ->
            if (i in expandableRows) {
                rowOffset += expandFactor - 1
            }

            var columnOffset = 0
            row.forEachIndexed { j, c ->
                if (j in expandableColumns) {
                    columnOffset += expandFactor - 1
                }

                if (c == '#') {
                    stars += Point(j + columnOffset, i + rowOffset)
                    originalStars += Point(j, i)
                }
            }
        }
//        printStars(originalStars, "Original")
//        printStars(stars, "Final")

        return stars
    }

    private fun printStars(stars: List<Point>, type: String) {
        println("$type stars: ")
        println(stars.map { "[${it.x},${it.y}]" })
    }

}
