/**
 * An implementation of a Doubly Linked List Class
 * @param T data stored in the list
 */
class DoublyLinkedList<T> {
    private var head: DLLNode<T>? = null
    private var tail: DLLNode<T>? = null

    /**
     * Adds the element [data] to the front of the linked list.
     * @param data the data to be added to the front of the list
     */
    fun pushFront(data: T) {
        val newNode = DLLNode(data)
        newNode.next = head
        if (head != null) {
            head?.prev = newNode
        }
        head = newNode
        newNode.prev = null
    }

    /**
     * Adds the element [data] to the back of the linked list.
     * @param data the data to be added to the back of the list
     */
    fun pushBack(data: T) {
        val newNode = DLLNode(data)
        tail?.next = newNode
        if (tail != null) {
            newNode.prev = tail
        }
        tail = newNode
        newNode.next = null
    }

    /**
     * Removes an element from the front of the list. If the list is empty, it is unchanged.
     * @return the value at the front of the list or nil if none exists
     */
    fun popFront(): T? {
        val tmpHead = peekFront()
        head = head?.next
        head?.prev = null
        return tmpHead
    }

    /**
     * Removes an element from the back of the list. If the list is empty, it is unchanged.
     * @return the value at the back of the list or nil if none exists
     */
    fun popBack(): T? {
        val tmpTail = peekBack()
        tail = tail?.prev
        tail?.next = null
        return tmpTail
    }

    /**
     * @return the value at the front of the list or nil if none exists
     */
    fun peekFront(): T? {
        return head?.data
    }

    /**
     * @return the value at the back of the list or nil if none exists
     */
    fun peekBack(): T? {
        return tail?.data
    }

    /**
     * @return true if the list is empty and false otherwise
     */
    fun isEmpty(): Boolean {
        return head == null
    }
}

/**
 * Represents a node in a doubly linked list.
 * @param T the type of data stored in the node
 * @property data the data stored in the node
 */
class DLLNode<T> (var data: T) {
    var prev: DLLNode<T>? = null
    var next: DLLNode<T>? = null
}
