package com.adventofcode.solution.day11

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFileAsTable
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

@Disabled
internal class Day11Test {

    private val solver = Day11()

    @Test
    fun test_day11_1_example() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day11/example.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(374)
    }

    @Test
    fun test_day11_1_actualData() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day11/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(9214785)
    }

    @Test
    fun test_day11_2_example() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day11/example.txt")
        // when
        val result = solver.task2(lines, 10)
        // then
        assertThat(result).isEqualTo(1030L)
    }

    @Test
    fun test_day11_2_actualData() {
        // given
        val lines: Array<String> = readLinesFromResourceFileAsTable("data/day11/data.txt")
        // when
        val result = solver.task2(lines, 1000000)
        // then
        assertThat(result).isEqualTo(613686987427L)
    }
}