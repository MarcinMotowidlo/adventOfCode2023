package com.adventofcode.solution.day10

import com.adventofcode.common.data.TextUtil
import com.adventofcode.common.data.Tree
import com.adventofcode.solution.day10.Directions.Companion.pointsConnects
import com.adventofcode.solution.day10.Directions.Companion.possibleConnectionsOf
import java.awt.Point

class Day10 {

    fun task1(input: Array<String>): Int {
        input.forEach { printLine(it) }

        val root = Tree.Node(data = locateStart(input), parent = null)
        val tree: Tree<Point> = Tree(root)
        tmp(input, null, root, tree, root.data, true)


        return 0
    }

    fun task2(input: Array<String>): Int {
        return 0
    }

    fun tmp(
        input: Array<String>,
        parent: Tree.Node<Point>?,
        node: Tree.Node<Point>,
        tree: Tree<Point>,
        start: Point,
        isStart: Boolean = false
    ) {
        val coordinates: Point = node.data
        val pointDirection = directionOfPoint(input, coordinates)


        if ((Direction.START != pointDirection || isStart)) {
            val possibleMoves = possibleConnectionsOf(pointDirection)

            possibleMoves.forEach { (singleDirection, directions) ->
                singleDirection.points.forEach { point ->
                    val newPoint = Point(coordinates.x + point.x, coordinates.y + point.y)
                    if (newPoint.x > 0 && newPoint.x < input.size && newPoint.y > 0 && newPoint.y < input[0].length) {
                        val newDirection = directionOfPoint(input, newPoint)
                        val newNode = Tree.Node(newPoint, parent)
//                        if (!childrenExists(newPoint, node.children)) {
                            node.children.add(newNode)
                            if (pointsConnects(
                                    pointDirection,
                                    newDirection
                                ) && (parent == null || parent.data != newPoint)
                            ) {
                                println("Found connection between $pointDirection and $newDirection at [${newPoint.x},${newPoint.y}]")
                                tmp(input, node, newNode, tree, start, false)
                            } else if (start == newPoint) {
                                println("Found start again $newPoint")
                                printTree(newNode)
                                calculateResult(newNode)
                            }
//                        }
                    }
                }
            }
        }
    }

    private fun childrenExists(newPoint: Point, children: MutableList<Tree.Node<Point>>): Boolean {
        return children.any { it.data.x == newPoint.x && it.data.y == newPoint.y }

    }

    private fun calculateResult(node: Tree.Node<Point>?) {
        if (node != null) {
            var count = 0
            var copy = node
            while (copy != null) {
                count++
                copy = copy.parent
            }
            println("Count $count")
        }
    }

    private fun printTree(node: Tree.Node<Point>?) {
        if (node?.parent != null) {
            println("-- [${node.data.x},${node.data.y}]")
            printTree(node.parent)
        }
    }

    private fun directionOfPoint(
        input: Array<String>,
        newPoint: Point
    ) = Direction.entries.first { it.symbol == (input[newPoint.y][newPoint.x]) }

    private fun locateStart(input: Array<String>): Point {
        input.withIndex().forEach { line ->
            line.value.withIndex().forEach { column ->
                if (column.value == Direction.START.symbol) {
                    return Point(column.index, line.index)
                }
            }
        }
        error("No start found")
    }

    private fun printLine(line: String) =
        println(line.map { char ->
            if (Direction.entries.map { it.symbol }.contains(char)) {
                TextUtil.bold(char)
            } else {
                char
            }
        })
}
