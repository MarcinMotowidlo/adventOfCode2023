package com.adventofcode.solution.day5

data class Seed(val id: Long)

data class GrowMap(
    val fromType: MapType,
    val toType: MapType,
    val sourceDestinationRange: MutableList<Triple<Long, Long, Long>>
)

enum class MapType {
    SEED, SOIL, FERTILIZER, WATER, LIGHT, TEMPERATURE, HUMIDITY, LOCATION
}

data class Range(
    var from: Long,
    var to: Long,
    var currentStep: MapType?,
    var calculateStep: MutableMap<MapType, Boolean> = mutableMapOf(),
    var rangeResults: MutableMap<Long, Long> = mutableMapOf()
) {
    fun extendsLeft(potentialRange: Range): Boolean =
        potentialRange.from < from && potentialRange.to >= from && potentialRange.to <= to

    fun extendsRight(potentialRange: Range): Boolean = potentialRange.from in from..to && potentialRange.to > to

    fun overlaps(potentialRange: Range): Boolean = potentialRange.from < from && potentialRange.to > to

    fun extendLeftRight(potentialRange: Range) {
        extendRight(potentialRange)
        extendLeft(potentialRange)
    }

    fun extendRight(potentialRange: Range) {
        to = potentialRange.to
    }

    fun extendLeft(potentialRange: Range) {
        from = potentialRange.from
    }
}