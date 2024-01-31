/**
 * An implementation of a LIFO structure Stack
 * @param T the type of data stored in the stack
 */
class Stack<T> {
    private val stack = DoublyLinkedList<T>()

    /**
     * Add [data] to the top of the stack
     * @param data the new value to put onto the stack
     */
    fun push(data: T) {
        return stack.pushFront(data)
    }

    /**
     * Remove the element at the top of the stack. If the stack is empty, it remains unchanged.
     * @return the value at the top of the stack or nil if none exists
     */
    fun pop(): T? {
        return stack.popFront()
    }

    /**
     * @return the value on the top of the stack or nil if none exists
     */
    fun peek(): T? {
        return stack.peekFront()
    }

    /**
     * @return true if the stack is empty and false otherwise
     */
    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }
}
