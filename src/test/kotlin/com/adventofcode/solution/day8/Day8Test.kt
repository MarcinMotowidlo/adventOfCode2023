package com.adventofcode.solution.day8

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day8Test {

    private val solver = Day8()

    @Test
    fun test_day8_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day8/example.txt").filter { it.isNotBlank() }
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun test_day8_1_example_2() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day8/example_2.txt").filter { it.isNotBlank() }
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun test_day8_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day8/data.txt").filter { it.isNotBlank() }
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(15989)
    }

    @Test
    fun test_day8_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day8/example_3.txt").filter { it.isNotBlank() }
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun test_day8_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day8/data.txt").filter { it.isNotBlank() }
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(13830919117339L)
    }
}