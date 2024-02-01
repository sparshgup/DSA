package org.example
import kotlin.time.measureTime

fun main() {

    // Problem 1: Mutable Int List
    println("=========================================")
    println("=========================================")
    println("MyMutableIntList")
    val arraySizes = listOf(100, 1000, 10000, 100000, 1000000, 10000000, 100000000)
    println("numberOfElements totalTime timePerElement")
    for (arraySize in arraySizes) {
        val myList = MyMutableIntList()
        val timeTaken = measureTime {
            for (i in 0..<arraySize) {
                myList.add(i)
            }
        }
        println("$arraySize $timeTaken ${timeTaken/arraySize}")
    }
    println("=========================================")
    println("In-built Kotlin MutableList<Int")
    println("numberOfElements totalTime timePerElement")
    for (arraySize in arraySizes) {
        val myList: MutableList<Int> = mutableListOf()
        val timeTaken = measureTime {
            for (i in 0..<arraySize) {
                myList.add(i)
            }
        }
        println("$arraySize $timeTaken ${timeTaken/arraySize}")
    }

    // Problem 2: Adjacency List
    println("=========================================")
    println("=========================================")
    println("Adjacency List")
    val adjacencyList = AdjacencyList<Int>()

    val vertex1 = adjacencyList.addVertex(1)
    val vertex2 = adjacencyList.addVertex(2)
    val vertex3 = adjacencyList.addVertex(3)
    val vertex4 = adjacencyList.addVertex(4)
    val vertex5 = adjacencyList.addVertex(5)

    adjacencyList.addEdge(vertex1, vertex2)
    adjacencyList.addEdge(vertex1, vertex3)
    adjacencyList.addEdge(vertex2, vertex4)
    adjacencyList.addEdge(vertex3, vertex1)
    adjacencyList.addEdge(vertex3, vertex5)
    adjacencyList.addEdge(vertex4, vertex5)
    adjacencyList.addEdge(vertex4, vertex3)
    adjacencyList.addEdge(vertex5, vertex4)

    print(adjacencyList)
}