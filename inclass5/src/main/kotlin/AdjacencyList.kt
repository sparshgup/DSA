package org.example

/**
 * Represents a graph using an adjacency list implementation.
 * @param T The type of data stored in each vertex.
 */
class AdjacencyList<T> {
    private val adjacencyMap = mutableMapOf<Vertex<T>, ArrayList<Edge<T>>>()

    /**
     * Adds a vertex to the graph.
     * @param data The data to be stored in the new vertex.
     * @return The newly added vertex.
     */
    fun addVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencyMap.count(), data)
        adjacencyMap[vertex] = arrayListOf()
        return vertex
    }

    /**
     * Adds an edge between two vertices in the graph.
     * @param start The starting vertex of the edge.
     * @param end The ending vertex of the edge.
     */
    fun addEdge(start: Vertex<T>, end: Vertex<T>) {
        val edge = Edge(start, end)
        adjacencyMap[start]?.add(edge)
    }

    /**
     * @return The string representation of the adjacency list.
     */
    override fun toString(): String {
        return buildString {
            adjacencyMap.forEach {
                (vertex, edges) -> val stringOfEdge = edges.joinToString {it.end.data.toString()}
                append("${vertex.data} --> [$stringOfEdge]\n")
            }
        }
    }
}

/**
 * Represents a vertex in the graph.
 * @param index The index of the vertex.
 * @param data The data stored in the vertex.
 */
data class Vertex<T>(val index: Int, val data: T)

/**
 * Represents an edge between two vertices in the graph.
 * @param start The starting vertex of the edge.
 * @param end The ending vertex of the edge.
 */
data class Edge<T>(val start: Vertex<T>, val end: Vertex<T>)