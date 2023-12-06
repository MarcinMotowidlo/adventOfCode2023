package com.adventofcode.solution.day6

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day6Test {

    private val solver = Day6()

    @Test
    fun test_day6_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day6/example.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(288L)
    }

    @Test
    fun test_day6_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day6/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(800280L)
    }

    @Test
    fun test_day6_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day6/example.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(71503L)
    }

    @Test
    fun test_day6_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day6/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(45128024L)
    }
}