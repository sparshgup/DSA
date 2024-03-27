/**
 * Represents a mapping of keys to values.
 * @param K the type of the keys
 * @param V the type of the values
 */
class AssociativeArray<K, V> {
    private var table: Array<Node<K, V>?>
    var capacity = 16
    private var size = 0

    init {
        table = arrayOfNulls(capacity)
    }

    /**
     * Insert the mapping from the key, [k], to the value, [v].
     * If the key already maps to a value, replace the mapping.
     */
    operator fun set(k: K, v: V) {
        val index = hash(k)
        var node = table[index]

        if (node == null) {
            node = Node(k, v)
            table[index] = node
            size++
            if (size >= capacity * 0.75) rehash()
        } else {
            var current = node
            while (current != null) {
                if (current.key == k) {
                    current.value = v
                    return
                }
                current = current.next
            }
            node.next = Node(k, v)
            size++
            if (size >= capacity * 0.75) rehash()
        }
    }

    /**
     * @return true if [k] is a key in the associative array
     */
    operator fun contains(k: K): Boolean {
        val index = hash(k)
        var node = table[index]
        while (node != null) {
            if (node.key == k) return true
            node = node.next
        }
        return false
    }

    /**
     * @return the value associated with the key [k] or null if it doesn't exist
     */
    operator fun get(k: K): V? {
        val index = hash(k)
        var node = table[index]
        while (node != null) {
            if (node.key == k) return node.value
            node = node.next
        }
        return null
    }

    /**
     * Remove the key, [k], from the associative array
     * @param k the key to remove
     * @return true if the item was successfully removed and false if the element was not found
     */
    fun remove(k: K): Boolean {
        val index = hash(k)
        var node = table[index]
        var prev: Node<K, V>? = null
        while (node != null) {
            if (node.key == k) {
                if (prev == null) {
                    table[index] = node.next
                } else {
                    prev.next = node.next
                }
                size--
                return true
            }
            prev = node
            node = node.next
        }
        return false
    }

    /**
     * @return the number of elements stored in the hash table
     */
    fun size(): Int = size

    /**
     * @return the full list of key value pairs for the associative array
     */
    fun keyValuePairs(): List<Pair<K, V>> {
        val pairs = mutableListOf<Pair<K, V>>()
        for (node in table) {
            var current = node
            while (current != null) {
                pairs.add(Pair(current.key, current.value))
                current = current.next
            }
        }
        return pairs
    }

    /**
     * @return the computed hash value for a given key.
     */
    fun hash(key: K): Int {
        return key.hashCode() % capacity
    }

    /**
     * Rehashes the hash table when it exceeds a certain threshold to minimize clustering.
     */
    fun rehash() {
        capacity = nextPrime(capacity * 2)
        val newTable = arrayOfNulls<Node<K, V>?>(capacity)
        for (node in table) {
            var current = node
            while (current != null) {
                val newIndex = hash(current.key)
                val newNode = Node(current.key, current.value)
                newNode.next = newTable[newIndex]
                newTable[newIndex] = newNode
                current = current.next
            }
        }
        table = newTable
    }

    /**
     * Checks if a number is prime.
     * @param n the given number
     * @return true if the number is prime, otherwise false
     */
    fun isPrime(n: Int): Boolean {
        if (n <= 1) return false
        if (n <= 3) return true
        if (n % 2 == 0 || n % 3 == 0) return false
        var i = 5
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) return false
            i += 6
        }
        return true
    }

    /**
     * Finds the next prime greater than a given number.
     * @param n the given number
     * @return the next prime after the given number
     */
    fun nextPrime(n: Int): Int {
        var next = n + 1
        while (!isPrime(next)) {
            next ++
        }
        return next
    }

}

class Node<K, V>(var key: K, var value: V) {
    var next: Node<K, V>? = null
}