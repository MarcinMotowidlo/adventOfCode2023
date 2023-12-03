package com.adventofcode.solution.day3

class Day3 {
    fun task1(input: Array<String>): Int {
        val parts: List<MachinePart> = input.flatMapIndexed { lineIndex, line -> identifyParts(lineIndex, line) }
        return parts.filter { it.isValid(input) }.sumOf { it.value }
    }

    fun task2(input: Array<String>): Int {
        val parts: List<MachinePart> = input.flatMapIndexed { lineIndex, line -> identifyParts(lineIndex, line) }
        val gears = mutableListOf<Gear>()

        input.forEachIndexed{ lineIndex, line ->
            line.forEachIndexed { index, char ->
                if (char.toString() == "*"){
                    gears.add(Gear(parts.filter { it.isNextToGear(lineIndex, index) }))
                }
            }
        }
        return gears.filter { it.machines.size == 2 }.sumOf { it.ratio() }
    }

    private fun identifyParts(lineIndex: Int, line: String): List<MachinePart> {
        val parts = mutableListOf<MachinePart>()
        var lastFoundDigit = 0
        line.forEachIndexed { index, char ->
            if (char.isDigit() && index >= lastFoundDigit) {
                // potential machine
                lastFoundDigit = index
                val buffer = StringBuffer()
                while (lastFoundDigit < line.length && line[lastFoundDigit].isDigit()) {
                    buffer.append(line[lastFoundDigit])
                    lastFoundDigit++
                }
                parts.add(
                    MachinePart(
                        lineNumber = lineIndex,
                        startIndex = index,
                        endIndex = lastFoundDigit - 1,
                        value = buffer.toString().toInt()
                    )
                )
            }
        }
        return parts
    }


}
