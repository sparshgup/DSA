/**
 * An implementation of a FIFO structure Queue
 * @param T the type of data stored in the queue
 */
class Queue<T> {
    private val queue = DoublyLinkedList<T>()

    /**
     * Add [data] to the end of the queue.
     * @param data the new value to put onto the stack
     */
    fun enqueue(data: T) {
        return queue.pushBack(data)
    }

    /**
     * Remove the element at the front of the queue.  If the queue is empty, it remains unchanged.
     * @return the value at the front of the queue or nil if none exists
     */
    fun dequeue(): T? {
        return queue.popFront()
    }

    /**
     * @return the value at the front of the queue or nil if none exists
     */
    fun peek(): T? {
        return queue.peekFront()
    }

    /**
     * @return true if the queue is empty and false otherwise
     */
    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }
}