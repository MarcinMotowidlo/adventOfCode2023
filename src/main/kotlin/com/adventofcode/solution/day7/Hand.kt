package com.adventofcode.solution.day7

data class Hand(val cards: List<Card>, val bet: Int) {

    fun groupCards(): Map<String, Int> {
        val cardMap = mutableMapOf<String, Int>()
        cards.forEach {
            if (cardMap.containsKey(it.symbol)) {
                cardMap[it.symbol] = cardMap[it.symbol]!! + 1
            } else {
                cardMap[it.symbol] = 1
            }
        }
        return cardMap
    }

    fun getHandStrength(): Int = HandStrengthCalculator.getHandStrength(this)

    fun maxHandStrength(): Int = HandStrengthCalculator.getMaxHandStrength(this)

    override fun toString(): String {
        val builder = StringBuilder()
        builder.append("Card: ")
        cards.forEach { builder.append(it.symbol) }
        builder.append(" | Bet: ")
        builder.append(bet)
        return builder.toString()
    }
}

enum class Card(val strength: Int, val strengthWithJacks: Int, val symbol: String) {
    A(114, 114, "A"),
    K(113, 113, "K"),
    Q(112,112, "Q"),
    J(111, 102, "J"),
    T(110, 111, "T"),
    _9(109, 110, "9"),
    _8(108, 109, "8"),
    _7(107, 108, "7"),
    _6(106, 107, "6"),
    _5(105, 106, "5"),
    _4(104, 105, "4"),
    _3(103, 104, "3"),
    _2(102, 103, "2");

    companion object {
        fun valueOfSymbol(symbol: Char): Card {
            return entries.first { it.symbol == symbol.toString() }
        }

    }
}
