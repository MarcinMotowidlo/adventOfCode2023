package com.adventofcode.solution.day5

private const val SEEDS = "seeds: "
private const val TO = "-to-"
private const val MAP = " map:"

class Day5 {

    fun task1(input: List<String>): Long {
        val seeds: List<Seed> = parseSeeds(input[0])
        val growMaps = parseGrowMaps(input.subList(1, input.size).filter { it.isNotBlank() })
        return seeds.minOf { calculateAll(it, growMaps) }
    }

    fun task2(input: List<String>): Long {
        val growMaps = parseGrowMaps(input.subList(1, input.size).filter { it.isNotBlank() })
        return parseAndProcess(input[0], growMaps)
    }

    private fun parseSeeds(line: String): List<Seed> {
        return line.substring(line.indexOf(SEEDS) + SEEDS.length, line.length)
            .split(" ")
            .filter { it.isNotBlank() }
            .map { Seed(it.toLong()) }
    }

    private fun parseAndProcess(line: String, growMaps: MutableMap<MapType, GrowMap>): Long {
        var min: Long = Long.MAX_VALUE
        val lineNumbers: List<Long> = line.substring(line.indexOf(SEEDS) + SEEDS.length, line.length)
            .split(" ")
            .filter { it.isNotBlank() }
            .map { it.toLong() }

        val seeds: Set<Long> = mutableSetOf()

        var ranges = mutableSetOf<Range>()

        val listIterator = lineNumbers.iterator()
        while (listIterator.hasNext()) {
            val from = listIterator.next()
            val range = listIterator.next()
            val potentialRange = Range(from, from + range, currentStep = null)

            if (!(ranges.any { it.extendsLeft(potentialRange) } ||
                        ranges.any { it.extendsRight(potentialRange) } ||
                        ranges.any { it.overlaps(potentialRange) }
                        )) {
                ranges.add(potentialRange)
            } else {
                ranges.filter { it.extendsLeft(potentialRange) }.forEach { it.extendLeft(potentialRange) }
                ranges.filter { it.extendsRight(potentialRange) }.forEach { it.extendLeft(potentialRange) }
                ranges.filter { it.overlaps(potentialRange) }.forEach { it.extendLeftRight(potentialRange) }
            }
        }
        ranges.sortedBy { it.from }
        println("Amount of seeds: " + ranges.sumOf { it.to - it.from } / 1000000 + "M")

        var iterations: Long = 0

        ranges.forEach {
            for (i in it.from..it.to) {
                if (!seeds.contains(i)) {
                    seeds.plus(i)
                    val result = calculateAll(Seed(i), growMaps)
                    iterations++
                    if (result < min) {
                        min = result
                    }
                }
                if (iterations % 1000000 == 0L) {
                    println("Iterations: " + iterations / 1000000 + "M")
                }
            }
        }

        return min
    }

    private fun parseGrowMaps(input: List<String>): MutableMap<MapType, GrowMap> {
        val growMaps = mutableMapOf<MapType, GrowMap>()
        val iterator = input.iterator()
        var currentMap: GrowMap? = null
        while (iterator.hasNext()) {
            val line: String = iterator.next()
            if (line.contains(TO)) {
                if (currentMap != null) {
                    growMaps[currentMap.fromType] = currentMap
                }
                currentMap = GrowMap(
                    fromType = MapType.valueOf(line.substring(0, line.indexOf(TO)).uppercase()),
                    toType = MapType.valueOf(
                        line.substring(line.indexOf(TO) + TO.length, line.indexOf(MAP)).uppercase()
                    ),
                    sourceDestinationRange = mutableListOf()
                )
            } else {
                val splittedMap = line.split(" ")
                assert(splittedMap.size == 3)
                currentMap!!.sourceDestinationRange.add(
                    Triple(
                        splittedMap[1].toLong(), // source
                        splittedMap[0].toLong(), // destination
                        splittedMap[2].toLong() // range
                    )
                )
            }
        }
        // add last map
        growMaps[currentMap!!.fromType] = currentMap
        return growMaps
    }

    private fun calculateAll(seed: Seed, growMaps: MutableMap<MapType, GrowMap>): Long {
        val soil = calculate(seed.id, growMaps[MapType.SEED]!!)
        val fertilizer = calculate(soil, growMaps[MapType.SOIL]!!)
        val water = calculate(fertilizer, growMaps[MapType.FERTILIZER]!!)
        val light = calculate(water, growMaps[MapType.WATER]!!)
        val temperature = calculate(light, growMaps[MapType.LIGHT]!!)
        val humidity = calculate(temperature, growMaps[MapType.TEMPERATURE]!!)
        return calculate(humidity, growMaps[MapType.HUMIDITY]!!)
    }

    private fun calculate(input: Long, growMap: GrowMap): Long {

        val match: Triple<Long, Long, Long>? = growMap.sourceDestinationRange.find {
            it.first <= input && input <= it.first + it.third
        }
        return if (match != null) {
            match.second + input - match.first
        } else {
            input
        }
    }

}


