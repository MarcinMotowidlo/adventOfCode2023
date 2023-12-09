package com.adventofcode.solution.day7

sealed class HandType {
    abstract fun isApplicable(hand: Hand): Boolean

    abstract fun handStrength(): Int
}


class HandStrengthCalculator {

    companion object {
        private val handTypes: Set<HandType> = setOf(HighCard, Pair, TwoPairs, Triple, FullHouse, Quads, Fives)
        fun getHandStrength(hand: Hand): Int {
            return handTypes.filter { it.isApplicable(hand) }.maxOf { it.handStrength() }
        }

        fun getMaxHandStrength(hand: Hand): Int {
            return if (!hand.cards.contains(Card.J)) {
                getHandStrength(hand)
            } else {
                val jIndexes: MutableList<Int> = getJIndexes(hand)
                val permutations: MutableList<Hand> = mutableListOf()
                replace(listOf(hand), jIndexes, permutations)

                permutations.filter { !it.cards.contains(Card.J) }
                    .maxOf { perm ->
                        handTypes.filter { it.isApplicable(perm) }
                            .maxOf { it.handStrength() }
                    }
            }
        }

        private fun getJIndexes(hand: Hand) = hand.cards.mapIndexed { index, card ->
            if (card == Card.J) {
                index
            } else null
        }.filterNotNull()
            .toMutableList()

        private fun replace(hands: List<Hand>, jIndexes: MutableList<Int>, permutations: MutableList<Hand>) {
            val iterator = jIndexes.iterator()
            while (iterator.hasNext()) {
                val index = iterator.next()
                Card.entries.forEach {
                    if (it != Card.J) {
                        hands.forEach { hand ->
                            val permutedCards = hand.cards.toMutableList()
                            permutedCards[index] = it
                            permutations.add(Hand(permutedCards, hand.bet))
                        }
                    }
                }
                iterator.remove()
                replace(permutations.toMutableList(), jIndexes, permutations)
            }

        }

    }
}

data object HighCard : HandType() {
    override fun isApplicable(hand: Hand): Boolean = hand.groupCards().filter { it.value > 1 }.isEmpty()
    override fun handStrength(): Int = 100
}

data object Pair : HandType() {
    override fun isApplicable(hand: Hand): Boolean = hand.groupCards().filter { it.value == 2 }.size == 1 &&
            hand.groupCards().filter { it.value > 2 }.isEmpty()

    override fun handStrength(): Int = 200
}

data object TwoPairs : HandType() {
    override fun isApplicable(hand: Hand): Boolean = hand.groupCards().filter { it.value == 2 }.size == 2
    override fun handStrength(): Int = 300
}

data object Triple : HandType() {
    override fun isApplicable(hand: Hand): Boolean = hand.groupCards().filter { it.value == 3 }.size == 1 &&
            hand.groupCards().filter { it.value == 1 }.size == 2

    override fun handStrength(): Int = 400
}

data object FullHouse : HandType() {
    override fun isApplicable(hand: Hand): Boolean =
        hand.groupCards().filter { it.value == 3 }.size == 1 && hand.groupCards().filter { it.value == 2 }.size == 1

    override fun handStrength(): Int = 500
}

data object Quads : HandType() {
    override fun isApplicable(hand: Hand): Boolean = hand.groupCards().filter { it.value == 4 }.size == 1
    override fun handStrength(): Int = 600
}

data object Fives : HandType() {
    override fun isApplicable(hand: Hand): Boolean = hand.groupCards().filter { it.value == 5 }.size == 1
    override fun handStrength(): Int = 700
}