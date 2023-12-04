package com.adventofcode.solution.day3

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFileAsTable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day3Test {

    private val solver = Day3()

    @Test
    fun test_day3_1_example() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day3/example.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(4361)
    }

    @Test
    fun test_day3_1_actualData() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day3/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(512794)
    }

    @Test
    fun test_day3_2_example() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day3/example.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(467835)
    }

    @Test
    fun test_day3_2_actualData() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day3/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(67779080)
    }
}