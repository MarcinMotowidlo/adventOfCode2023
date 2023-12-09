package com.adventofcode.solution.day8

data class Element(val members: List<String>) {

}

enum class LeftRight(val index: Int){
    L(0), R(1)
}