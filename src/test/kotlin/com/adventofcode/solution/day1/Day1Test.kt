package com.adventofcode.solution.day1

import com.adventofcode.common.data.DataUtil.Companion.readLinesFromResourceFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class Day1Test {

    private val solver = Day1()

    @Test
    fun test_day1_1_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day1/example_1.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(142)
    }

    @Test
    fun test_day1_1_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day1/data.txt")
        // when
        val result = solver.task1(lines)
        // then
        assertThat(result).isEqualTo(55712)
    }

    @Test
    fun test_day1_2_example() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day1/example_2.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(281)
    }

    @Test
    fun test_day1_2_actualData() {
        // given
        val lines: List<String> = readLinesFromResourceFile("data/day1/data.txt")
        // when
        val result = solver.task2(lines)
        // then
        assertThat(result).isEqualTo(55413)
    }

    @MethodSource("data")
    @ParameterizedTest
    internal fun test_day_2_singleText(line: String, expectedResult: Int) {
        // given
        // when
        val result = solver.task2(listOf(line))
        // then
        assertThat(result).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        private fun data(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("seveneight9eightnpjmh9eightfive", 75),
                Arguments.of("76five", 75),
                Arguments.of("bnjrnsdfjg6", 66),
                Arguments.of("21onebcsgvhtm6two", 22),
                Arguments.of("ph5mzknlknp5", 55),
                Arguments.of("gflktjvlfivetbgmbsxzdpdxjdgkzvn851sixfour", 54),
                Arguments.of("1threegkhpq7nfrksvm69nxpvgvthfzoneighttc", 18),
                Arguments.of("2kjkbbvftktkvpbp8gkcnrrkr6r", 26),
                Arguments.of("dlbzctlxpjxxqk96pmdgdfblbfjnsxjmkoneqgeight", 98),
                Arguments.of("1jbdtfcdvvbzhgfsixrzqxkfktjmhkhfive5", 15),
                Arguments.of("vjcg4p", 44),
                Arguments.of("6pcjglgdknjoneightssb", 68),
                Arguments.of("joneight9", 19),
            )
        }
    }

}