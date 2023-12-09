package com.adventofcode.solution.day8

const val SEPARATOR: String = " = "

class Day8 {
    fun task1(input: List<String>): Int {

        val (instructions: List<LeftRight>, multimap: MutableMap<String, List<String>>) = data(input)

        var currentPoint = "AAA"
        val result = reachFirstZ("ZZZ", currentPoint, multimap, instructions)
//        println("Current point: " + currentPoint + " | firstZZZ: " + result.first + " | lastIndex: " + result.second + "[" + instructions[result.second] + "]")
        return result.second
    }

    private fun data(input: List<String>): Pair<List<LeftRight>, MutableMap<String, List<String>>> {
        val instructions: List<LeftRight> = input[0].split("").filter { it.isNotBlank() }.map { LeftRight.valueOf(it) }

        val multimap: MutableMap<String, List<String>> = mutableMapOf()
        input.subList(1, input.size).forEach {
            val entry = parse(it)
            multimap[entry.first] = entry.second
        }
        return Pair(instructions, multimap)
    }

    fun task2(input: List<String>): Long {
        val (instructions: List<LeftRight>, multimap: MutableMap<String, List<String>>) = data(input)

        val inputs: List<String> = multimap.filter { it.key.endsWith("A") }.map { it.key }

        val numbers: MutableMap<String, List<Int>> = mutableMapOf()

        inputs.forEach { entryPoint ->
            val firstZ = reachFirstZ("Z", entryPoint, multimap, instructions)
//            println("Entry point: " + entryPoint + " | firstZ: " + firstZ.first + " in " + firstZ.second + " steps | lastIndex: " + firstZ.third + "[" + instructions[firstZ.third] + "]")
            val nextZ: List<Pair<String, Int>> = nextZs(firstZ.first, multimap, instructions, firstZ.third)
//            nextZ.forEach {
//                println("Next Z: " + it.first + " in " + it.second + " steps")
//            }
            numbers[entryPoint] = listOf(firstZ.second).plus(nextZ.map { it.second })
        }
        return nextCommonZ(numbers)
    }


    private fun nextCommonZ(results: MutableMap<String, List<Int>>): Long {

        val uniqueList: List<Long> = results.flatMap { it.value }.map { it.toLong() }.distinct()
        var result: Long = uniqueList[0]
        for (i in 1..<uniqueList.size) {
            result = findLCM(result, uniqueList[i])
        }
        return result
    }

    private fun reachFirstZ(
        z: String,
        entryPoint: String,
        multimap: MutableMap<String, List<String>>,
        instructions: List<LeftRight>
    ): Triple<String, Int, Int> {
        var currentPoint = entryPoint
        var i = 0
        var instructionIndex = 0
//        println("Current point: " + currentPoint + " | values: " + multimap[currentPoint] + " took: " + instructions[0])

        while (!currentPoint.endsWith(z)) {
            instructionIndex = i % instructions.size
            currentPoint = multimap[currentPoint]!![instructions[instructionIndex].index]
            i++
//            println("Current point: " + currentPoint + " | values: " + multimap[currentPoint] + " took: " + instructions[i % instructions.size])
        }

        return Triple(currentPoint, i, instructionIndex)
    }

    private fun nextZs(
        entryPoint: String,
        multimap: MutableMap<String, List<String>>,
        instructions: List<LeftRight>,
        entryIndex: Int
    ): List<Pair<String, Int>> {
        val result = mutableListOf<Pair<String, Int>>()
        var instructionIndex: Int = (entryIndex + 1) % instructions.size
        var currentPoint = multimap[entryPoint]!![instructions[instructionIndex].index]

//        println("Current point: " + currentPoint + " | values: " + multimap[currentPoint] + " took: " + instructions[0])
        instructionIndex++
        var steps = 1
        while (!result.map { it.first }.contains(entryPoint)) {
            while ((currentPoint != "XXX" && !currentPoint.endsWith("Z"))) {
                instructionIndex %= instructions.size
                currentPoint = multimap[currentPoint]!![instructions[instructionIndex].index]
                instructionIndex++
                steps++
//                println("Current point: " + currentPoint + " | values: " + multimap[currentPoint] + " took: " + instructions[instructionIndex % instructions.size])
            }
            result.add(Pair(currentPoint, steps))
        }
        return result
    }


    fun findLCM(a: Long, b: Long): Long {
        val larger = if (a > b) a else b
        val maxLcm = a * b
        var lcm = larger
        while (lcm <= maxLcm) {
            if (lcm % a == 0L && lcm % b == 0L) {
                return lcm
            }
            lcm += larger
        }
        return maxLcm
    }

    private fun parse(line: String): Pair<String, List<String>> {
        val splittedLine = line.split(SEPARATOR)
        val key = splittedLine[0]
        val values: List<String> = splittedLine[1].subSequence(1, splittedLine[1].length - 1).split(", ").toList()
        return Pair(key, values)
    }

}
