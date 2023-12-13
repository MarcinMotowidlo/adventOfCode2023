package com.adventofcode.solution.day12

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import com.adventofcode.solution.day11.Day12
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day12Test {

    private val solver = Day12()

    @Test
    fun test_day12_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day12/example.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(374)
    }

    @Test
    fun test_day12_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day12/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(9214785)
    }

    @Test
    fun test_day12_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day12/example.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(1030L)
    }

    @Test
    fun test_day12_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day12/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(613686987427L)
    }
}