package com.adventofcode.solution.day7

import kotlin.reflect.KProperty1


const val HAND_SIZE: Int = 5

class Day7 {
    fun task1(input: List<String>): Long {
        val hands: Map<Int, List<Hand>> = input.map { parseHand(it) }.groupBy { it.getHandStrength() }
        return calculate(hands, Card::strength)
    }

    fun task2(input: List<String>): Long {
        val hands: Map<Int, List<Hand>> = input.map { parseHand(it) }.groupBy { it.maxHandStrength() }
        return calculate(hands, Card::strengthWithJacks)
    }

    private fun calculate(
        hands: Map<Int, List<Hand>>,
        strengthProperty: KProperty1<Card, Int>
    ): Long {
        val sortedHands = mutableListOf<Hand>()
        hands.entries.sortedByDescending { it.key }
            .forEach { (_, hands) ->
                if (hands.size > 1) {
                    sortInternalHands(hands, strengthProperty).forEach { sortedHands.add(it) }
                } else {
                    sortedHands.add(hands[0])
                }
            }

//        sortedHands.withIndex().forEach {
//            println(it.value.toString() + " | Index:" + (sortedHands.size - it.index).toString())
//        }

        return sortedHands.withIndex().sumOf { (it.value.bet * (sortedHands.size - it.index)).toLong() }
    }

    private fun sortInternalHands(hands: List<Hand>, strengthProperty: KProperty1<Card, Int>): List<Hand> {
        val sortedCards = mutableMapOf<Double, Hand>()

        hands.forEach { hand ->
            val builder = StringBuilder()
            hand.cards.forEach { builder.append(strengthProperty.get(it)) }
            val adjustedStrength: Double = builder.toString().toDouble()

            if (sortedCards.containsKey(adjustedStrength)) {
                error("Adjusted strength shall be unique")
            }
            sortedCards[adjustedStrength] = hand
        }
        return sortedCards.entries.sortedByDescending { it.key }.map { it.value }
    }

    private fun parseHand(line: String): Hand {
        val splitLine: List<String> = line.split(" ")
        assert(splitLine.size == 2)
        assert(splitLine[0].length == HAND_SIZE)
        val cards = splitLine[0].map { Card.valueOfSymbol(it) }
        return Hand(
            cards = cards,
            bet = splitLine[1].toInt()
        )
    }
}
