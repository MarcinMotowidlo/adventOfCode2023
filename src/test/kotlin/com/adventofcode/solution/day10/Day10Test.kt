package com.adventofcode.solution.day10

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFileAsTable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Day10Test {

    private val solver = Day10()

    @Test
    fun test_day10_1_example() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day10/example_1.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(114L)
    }

    @Test
    fun test_day10_1_actualData() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day10/example_1.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(7093)
    }

    @Test
    fun test_day10_2_example() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day10/example_1.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(2L)
    }

    @Test
    fun test_day10_2_actualData() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day10/example_1.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(867L)
    }
}