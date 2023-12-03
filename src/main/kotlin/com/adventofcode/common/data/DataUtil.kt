package com.adventofcode.common.data

class DataUtil {

    companion object {

        fun readLinesFromResourceFile(fileName: String) =
            this::class.java.classLoader.getResourceAsStream(fileName)?.bufferedReader()?.readLines()
                ?: throw IllegalStateException("Unable to read file $fileName")

        fun readLinesFromResourceFileAsTable(fileName: String) =
            readLinesFromResourceFile(fileName).toTypedArray()
    }
}