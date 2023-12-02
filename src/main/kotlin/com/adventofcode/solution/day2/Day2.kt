package com.adventofcode.solution.day2

private const val GAME_SEPARATOR = ": "
private const val SETS_SEPARATOR = "; "
private const val CUBE_SET_SEPARATOR = ", "
private const val SINGLE_CUBE_SEPARATOR = " "

private const val GAME = "Game "

class Day2 {

    fun task1(input: List<String>, pool: Map<Colour, Int>): Int {
        return input.map { parse(it) }
            .filter { it.isValid(pool) }
            .sumOf { it.id }
    }

    fun task2(input: List<String>): Int {
        return input.sumOf { parse(it).power() }
    }

    private fun parse(line: String): Game {
        val separatedLine: List<String> = line.split(GAME_SEPARATOR)
        assert(separatedLine.size == 2)
        return Game(
            id = gameId(separatedLine[0]),
            draws = separatedLine[1].split(SETS_SEPARATOR).map { cubes(it) }
        )
    }

    private fun gameId(input: String): Int = input.substring(GAME.length).toInt()


    private fun cubes(draw: String): Draw {
        val cubes = mutableMapOf<Colour, Int>()

        draw.split(CUBE_SET_SEPARATOR).map {
            val singleCubes: List<String> = it.split(SINGLE_CUBE_SEPARATOR)
            assert(singleCubes.size == 2)
            cubes.put(Colour.valueOf(singleCubes[1].uppercase()) , singleCubes[0].toInt())
        }

        return Draw(cubes)
    }
}
