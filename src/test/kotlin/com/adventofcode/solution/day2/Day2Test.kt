package com.adventofcode.solution.day2

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Day2Test {

    private val solver = Day2()

    @Test
    fun test_day2_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day2/example.txt")
        val pool: Map<Colour, Int> = mapOf(Colour.RED to 12, Colour.GREEN to 13, Colour.BLUE to 14)
        // when
        val result = solver.task1(lines, pool)
        // then
        assertThat(result).isEqualTo(8)
    }

    @Test
    fun test_day2_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day2/data.txt")
        val pool: Map<Colour, Int> = mapOf(Colour.RED to 12, Colour.GREEN to 13, Colour.BLUE to 14)
        // when
        val result = solver.task1(lines, pool)
        // then
        assertThat(result).isEqualTo(2164)
    }

    @Test
    fun test_day2_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day2/example.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(2286)
    }

    @Test
    fun test_day2_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day2/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(69929)
    }
}