package com.adventofcode.solution.day4

private const val CARD = "Card "

class Day4 {

    fun task1(input: List<String>): Int {
        val cards: List<Card> = input.map { parseCard(it) }
        return cards.sumOf { it.result() }
    }

    fun task2(input: List<String>): Int {
        val cardMap: Map<Int, Card> = input.map { parseCard(it) }.associateBy { it.cardNumber }
        val cardList: MutableList<Card> = cardMap.values.toMutableList()
        var index = 0

        while(index < cardList.size){
            val card: Card = cardList[index]
            for (i in card.cardNumber..<card.cardNumber + card.matches()) {
                if (i < cardMap.size && cardMap.containsKey(i + 1)) {
                    cardList.add(cardMap[i + 1]!!)
                }
            }
            index++
        }
        return cardList.size
    }

    private fun parseCard(line: String): Card {
        val cardNumber = line.substring(CARD.length, line.indexOf(":", CARD.length))

        val winningNumbers = line.substring(line.indexOf(cardNumber) + cardNumber.length + 2, line.indexOf("|") - 1)
            .split(" ")
            .filter { it.isNotBlank() }
            .map { it.toInt() }
            .toSet()

        val cardNumbers = line.substring(line.indexOf("|") + 2)
            .split(" ")
            .filter { it.isNotBlank() }
            .map { it.toInt() }
            .toSet()

        return Card(
            cardNumber = cardNumber.trimStart().toInt(),
            winningNumbers = winningNumbers,
            cardNumbers = cardNumbers
        )
    }
}


