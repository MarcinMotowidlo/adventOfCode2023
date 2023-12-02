package com.adventofcode.solution.day2

data class Game(val id: Int, val draws: List<Draw>) {

    fun isValid(pool: Map<Colour, Int>): Boolean {
        return !draws.any { !it.isValid(pool) }
    }

    fun power(): Int{
        var power = 1
        minCubesNeeded().forEach { power *= it.value }
        return power
    }

    private fun minCubesNeeded(): Map<Colour, Int>{
        val cubesNeeded = mutableMapOf<Colour, Int>()
        Colour.values().forEach {colour ->
            var min = 0
            this.draws.forEach{ draw ->
                if (draw.cubes.containsKey(colour) && draw.cubes[colour]!! > min){
                    min = draw.cubes[colour]!!
                }
            }
            cubesNeeded[colour] = min
        }
        return cubesNeeded
    }
}

data class Draw(val cubes: Map<Colour, Int>) {
    fun isValid(pool: Map<Colour, Int>): Boolean =
        !this.cubes.any { cubes -> pool[cubes.key] != null && pool[cubes.key]!! < cubes.value }
}


enum class Colour {
    BLUE,
    RED,
    GREEN
}