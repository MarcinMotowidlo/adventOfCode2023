package com.adventofcode.common.data


data class Tree<T>(val root: Node<T>) {
    data class Node<T>(val data: T, val parent: Node<T>?, val children: MutableList<Node<T>> = mutableListOf()) {

        fun addChild(child: T, parent: Node<T>): Node<T> {
            val childNode: Node<T> = Node(data = child, parent)
            this.children!!.add(childNode)
            return childNode
        }
    }

}