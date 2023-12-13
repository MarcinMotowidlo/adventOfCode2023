package com.adventofcode.common.data

import java.awt.Point


const val BOLD_ON = "\u001B[1m"
const val BOLD_OFF = "\u001B[0m"

class TextUtil {
    companion object {

        fun bold(text: String): String = BOLD_ON + text + BOLD_OFF

        fun bold(char: Char): String = BOLD_ON + char.toString() + BOLD_OFF

        fun printlnBold(text: String) = println(bold(text))

        fun printBold(text: String) = print(bold(text))
        fun printBold(char: Char) = print(bold(char))

    }
}