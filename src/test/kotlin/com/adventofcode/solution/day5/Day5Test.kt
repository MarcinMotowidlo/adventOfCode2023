package com.adventofcode.solution.day5

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class Day5Test {

    private val solver = Day5()

    @Test
    fun test_day5_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day5/example.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(35)
    }

    @Test
    fun test_day5_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day5/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(346433842L)
    }

    @Test
    fun test_day5_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day5/example.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(46L)
    }

    @Test
    @Disabled("ugly solution, too big volumen")
    fun test_day5_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day5/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(60294664)
    }
}