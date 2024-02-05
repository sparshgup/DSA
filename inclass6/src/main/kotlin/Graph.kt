import java.util.*

class Graph<VertexType> {
    private var vertices: MutableSet<VertexType> = mutableSetOf()
    private var edges: MutableMap<VertexType, MutableSet<VertexType>> = mutableMapOf()

    /**
     * Add the vertex [v] to the graph
     * @param v the vertex to add
     * @return true if the vertex is successfully added, false if the vertex
     *   was already in the graph
     */
    fun addVertex(v: VertexType): Boolean {
        if (vertices.contains(v)) {
            return false
        }
        vertices.add(v)
        return true
    }

    /**
     * Add an edge between vertex [from] connecting to vertex [to]
     * @param from the vertex for the edge to originate from
     * @param to the vertex to connect the edge to
     * @return true if the edge is successfully added and false if the edge
     *     can't be added or already exists
     */
    fun addEdge(from: VertexType, to: VertexType): Boolean {
        if (!vertices.contains(from) || !vertices.contains(to)) {
            return false
        }
        edges[from]?.also { currentAdjacent ->
            if (currentAdjacent.contains(to)) {
                return false
            }
            currentAdjacent.add(to)
        } ?: run {
            edges[from] = mutableSetOf(to)
        }
        return true
    }

    /**
     * Clear all vertices and edges
     */
    fun clear() {
        vertices = mutableSetOf()
        edges = mutableMapOf()
    }

    /**
     * Breadth-First Search (BFS) algorithm
     *
     * @param root the starting vertex
     * @param target the destination/target vertex
     * @return true if there exists a path from root to target
     *      and false if it does not
     */
    fun BFS(root: VertexType, target: VertexType): Boolean {
        val marked: MutableSet<VertexType> = mutableSetOf()
        val priorityList: Queue<VertexType> = LinkedList()

        priorityList.add(root)
        marked.add(root)

        while (!priorityList.isEmpty()) {
            val n = priorityList.poll()
            if (n == target) {
                return true
            }
            for (m in edges[n]?:mutableSetOf()) {
                priorityList.add(m)
                marked.add(m)
            }
        }

        return false // no path
    }

    /**
     * Depth-First Search (DFS) algorithm
     *
     * @param root the starting vertex
     * @param target the destination/target vertex
     * @return true if there exists a path from root to target
     *      and false if it does not
     */
    fun DFS(root: VertexType, target: VertexType): Boolean {
        val marked: MutableSet<VertexType> = mutableSetOf()
        val priorityList = Stack<VertexType>()

        priorityList.push(root)
        marked.add(root)

        while (!priorityList.isEmpty()) {
            val n = priorityList.pop()
            if (n == target) {
                return true
            }
            for (m in edges[n]?:mutableSetOf()) {
                priorityList.push(m)
                marked.add(root)
            }
        }

        return false // no path
    }
}