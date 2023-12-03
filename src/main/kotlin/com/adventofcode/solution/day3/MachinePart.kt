package com.adventofcode.solution.day3

private const val DOT = "."

data class MachinePart(val lineNumber: Int, val startIndex: Int, val endIndex: Int, val value: Int) {

    fun isValid(input: Array<String>): Boolean {

        for (i in startIndex..endIndex) {
            val lineBefore = if (lineNumber - 1 >= 0) lineNumber - 1 else -1
            val indexBefore = if (i - 1 >= 0) i - 1 else -1
            val indexAfter = if (i + 1 < input[i].length) i + 1 else -1
            val lineAfter = if (lineNumber + 1 < input.size) lineNumber + 1 else -1

            // line Before
            if (lineBefore >= 0) {
                if (checkLine(input[lineBefore], indexBefore, i, indexAfter)) {
                    return true
                }
            }

            // current line
            if (checkLine(input[lineNumber], indexBefore, i, indexAfter)) {
                return true
            }

            // line after
            if (lineAfter >= 0) {
                if (checkLine(input[lineAfter], indexBefore, i, indexAfter)) {
                    return true
                }
            }
        }
        return false
    }

    fun isNextToGear(line: Int, index: Int): Boolean =
        (line == lineNumber - 1 && (startIndex - 1 <= index && index <= endIndex + 1)) ||
                (line == lineNumber && (index == startIndex - 1 || index == endIndex + 1)) ||
                (line == lineNumber + 1 && (startIndex - 1 <= index && index <= endIndex + 1))


private fun checkLine(line: String, indexBefore: Int, index: Int, indexAfter: Int): Boolean =
    (indexBefore > -1 && isSymbol(line[indexBefore])) ||
            isSymbol(line[index]) ||
            (indexAfter > -1 && isSymbol(line[indexAfter]))

private fun isSymbol(char: Char): Boolean = !char.isDigit() && char.toString() != DOT
}

data class Gear(val machines: List<MachinePart>){

    fun ratio(): Int {
        var result = 1
        machines.forEach{result*= it.value}
        return result
    }
}