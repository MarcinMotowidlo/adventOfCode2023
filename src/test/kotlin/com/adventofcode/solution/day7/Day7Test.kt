package com.adventofcode.solution.day7

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day7Test {

    private val solver = Day7()

    @Test
    fun test_day7_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day7/example.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(6440L)
    }

    @Test
    fun test_day7_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day7/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(250951660L)
    }

    @Test
    fun test_day7_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day7/example.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(5905L)
    }

    @Test
    fun test_day7_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day7/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(251481660L)
    }

}