/**
 * A class that creates a Min Heap data structure.
 *
 * Sources:
 *  1. Introduction to Algorithms CLRS
 *  2. https://tildesites.bowdoin.edu/~ltoma/teaching/cs231/fall09/Homeworks/old/rest/H5-sol.pdf
 *
 * @param T The type of elements stored in the heap.
 * @property vertices The list of pairs representing vertices and their associated values.
 * @property indexMap A map storing the index of each vertex in the heap.
 */
class MinHeap<T> {
    private var vertices: MutableList<Pair<T, Double>> = mutableListOf()
    private var indexMap: MutableMap<T, Int> = mutableMapOf()

    /**
     * Checks if the heap is empty.
     * @return `true` if the heap is empty, `false` otherwise.
     */
    fun isEmpty(): Boolean {
        return vertices.isEmpty()
    }

    /**
     * Inserts a new vertex with its associated value into the heap.
     * @param vertex The vertex to be inserted.
     * @param value The value associated with the vertex.
     * @throws IllegalArgumentException If the vertex already exists in the heap.
     */
    fun insert(vertex: T, value: Double) {
        if (indexMap.containsKey(vertex)) {
            throw IllegalArgumentException("Vertex already exists in the heap")
        }
        vertices.add(Pair(vertex, value))
        indexMap[vertex] = vertices.size - 1
        percolateUp(vertices.size - 1)
    }

    /**
     * Extracts and removes the minimum element (vertex) from the heap.
     * @return The minimum element (vertex) in the heap, or `null` if the heap is empty.
     */
    fun extractMin(): T? {
        if (isEmpty()) return null
        val min = vertices[0].first
        swap(0, vertices.size - 1)
        vertices.removeAt(vertices.size - 1)
        indexMap.remove(min)
        if (!isEmpty()) {
            indexMap[vertices[0].first] = 0
            percolateDown(0)
        }
        return min
    }

    /**
     * Decreases the value associated with a given vertex in the heap.
     * @param vertex The vertex whose value is to be decreased.
     * @param newValue The new value associated with the vertex.
     * @throws IllegalArgumentException If the new value is not smaller than the current value.
     * @throws NoSuchElementException If the specified vertex is not found in the heap.
     */
    fun decreaseKey(vertex: T, newValue: Double) {
        val index = getIndex(vertex)
        index?.let {
            if (newValue > vertices[it].second) {
                throw IllegalArgumentException("New value is not smaller than the current value")
            }
            vertices[it] = Pair(vertex, newValue)
            percolateUp(it)
        } ?: throw NoSuchElementException("Vertex not found in the heap")
    }

    /**
     * Moves a vertex up in the heap to maintain the heap property after insertion or key decrease.
     * @param index The index of the vertex to be moved up.
     */
    private fun percolateUp(index: Int) {
        var currentIndex = index
        while (currentIndex > 0) {
            val parentIndex = (currentIndex - 1) / 2
            if (vertices[currentIndex].second < vertices[parentIndex].second) {
                swap(currentIndex, parentIndex)
                currentIndex = parentIndex
            } else {
                break
            }
        }
    }

    /**
     * Moves a vertex down in the heap to maintain the heap property after extraction or key decrease.
     * @param index The index of the vertex to be moved down.
     */
    private fun percolateDown(index: Int) {
        var currentIndex = index
        while (true) {
            val left = 2 * currentIndex + 1
            val right = 2 * currentIndex + 2
            var smallest = currentIndex

            if (left < vertices.size && vertices[left].second < vertices[smallest].second) {
                smallest = left
            }
            if (right < vertices.size && vertices[right].second < vertices[smallest].second) {
                smallest = right
            }
            if (smallest != currentIndex) {
                swap(currentIndex, smallest)
                currentIndex = smallest
            } else {
                break
            }
        }
    }

    /**
     * Swaps the positions of two vertices in the heap and updates their indices in the index map.
     * @param i The index of the first vertex.
     * @param j The index of the second vertex.
     */
    private fun swap(i: Int, j: Int) {
        val tmp = vertices[i]
        vertices[i] = vertices[j]
        vertices[j] = tmp
        indexMap[vertices[i].first] = i
        indexMap[vertices[j].first] = j
    }

    /**
     * Retrieves the index of a given vertex in the heap.
     * @param vertex The vertex whose index is to be retrieved.
     * @return The index of the specified vertex, or `null` if the vertex is not in the heap.
     */
    private fun getIndex(vertex: T): Int? {
        return indexMap[vertex]
    }
}