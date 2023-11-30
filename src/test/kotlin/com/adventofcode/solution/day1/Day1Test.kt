package com.adventofcode.solution.day1

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class Day1Test {

    private val solver = Day1()

    @Test
    fun testDay1() {
        // given
        val filename = "data/exampleData.txt"
        val lines: List<String> = readLinesFromResourceFile(filename)
        // when
        val result = solver.solution(lines.toTypedArray())
        // then
        assertThat(result).isEqualTo("Hello, World! Advent of Code")
    }
}