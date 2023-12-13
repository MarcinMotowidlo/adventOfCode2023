package com.adventofcode.solution.day10

import java.awt.Point

class Directions {

    companion object {
        fun possibleConnectionsOf(from: Direction): Map<Direction, Set<Direction>> {
            return when (from) {
                Direction.NORTH_SOUTH -> mapOf(
                    Direction.NORTH_SOUTH to setOf(Direction.NORTH_SOUTH),

                    Direction.NORTH_EAST to setOf(Direction.NORTH_SOUTH),
                    Direction.SOUTH_EAST to setOf(Direction.NORTH_SOUTH),
                    Direction.SOUTH_WEST to setOf(Direction.NORTH_SOUTH),
                    Direction.NORTH_WEST to setOf(Direction.NORTH_SOUTH),
                )

                Direction.WEST_EAST-> mapOf(
                    Direction.WEST_EAST to setOf(Direction.WEST_EAST),

                    Direction.NORTH_EAST to setOf(Direction.WEST_EAST),
                    Direction.SOUTH_EAST to setOf(Direction.WEST_EAST),
                    Direction.SOUTH_WEST to setOf(Direction.WEST_EAST),
                    Direction.NORTH_WEST to setOf(Direction.WEST_EAST),
                )

                Direction.NORTH_EAST -> mapOf(
                    Direction.NORTH_SOUTH to setOf(Direction.NORTH_SOUTH),
                    Direction.WEST_EAST to setOf(Direction.WEST_EAST),
                )

                Direction.SOUTH_EAST -> mapOf(
                    Direction.NORTH_SOUTH to setOf(Direction.NORTH_SOUTH),
                    Direction.WEST_EAST to setOf(Direction.WEST_EAST),
                )

                Direction.SOUTH_WEST -> mapOf(
                    Direction.NORTH_SOUTH to setOf(Direction.NORTH_SOUTH),
                    Direction.WEST_EAST to setOf(Direction.WEST_EAST),
                )

                Direction.NORTH_WEST -> mapOf(
                    Direction.NORTH_SOUTH to setOf(Direction.NORTH_SOUTH),
                    Direction.WEST_EAST to setOf(Direction.WEST_EAST),
                )

                Direction.START -> mapOf(
                    Direction.WEST_EAST to setOf(Direction.WEST_EAST),
                    Direction.NORTH_SOUTH to setOf(Direction.NORTH_SOUTH),

                    Direction.NORTH_EAST to setOf(Direction.NORTH_SOUTH, Direction.WEST_EAST),
                    Direction.SOUTH_EAST to setOf(Direction.NORTH_SOUTH, Direction.WEST_EAST),
                    Direction.SOUTH_WEST to setOf(Direction.NORTH_SOUTH, Direction.WEST_EAST),
                    Direction.NORTH_WEST to setOf(Direction.NORTH_SOUTH, Direction.WEST_EAST),

                    )

                else -> emptyMap()
            }
        }


        fun pointsConnects(a: Direction, b: Direction): Boolean =
            possibleConnectionsOf(a).containsKey(b)
    }
}

enum class Direction(val points: Set<Point>, val symbol: Char) {

    NORTH_SOUTH(setOf(Point(0, 1), Point(0, -1)), '|'),
    WEST_EAST(setOf(Point(1, 0), Point(-1, 0)), '-'),

    NORTH_EAST(setOf(Point(0, 1), Point(-1, 0)), 'L'),
    SOUTH_EAST(setOf(Point(0, -1), Point(-1, 0)), 'F'),
    SOUTH_WEST(setOf(Point(0, 1), Point(1, 0)), '7'),
    NORTH_WEST(setOf(Point(0, -1), Point(-1, 0)), 'J'),

    CENTER(emptySet(), '.'),
    START(setOf(Point(1, 0), Point(-1, 0), Point(0, 1), Point(0, -1)), 'S');

    override fun toString(): String {
        return this.symbol.toString()
    }

}