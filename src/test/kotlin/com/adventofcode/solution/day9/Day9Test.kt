package com.adventofcode.solution.day9

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DayTest {

    private val solver = Day9()

    @Test
    fun test_day9_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day9/example_1.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(94L)
    }

    @Test
    fun test_day9_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day9/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(1772145754L)
    }

    @Test
    fun test_day9_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day9/example_1.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(2L)
    }

    @Test
    fun test_day9_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day9/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(867L)
    }
}