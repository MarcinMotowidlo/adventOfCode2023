package com.adventofcode.solution.day4

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day4Test {

    private val solver = Day4()

    @Test
    fun test_day4_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day4/example.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(13)
    }

    @Test
    fun test_day4_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day4/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(33950)
    }

    @Test
    fun test_day4_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day4/example.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(30)
    }

    @Test
    fun test_day4_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day4/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(14814534)
    }
}