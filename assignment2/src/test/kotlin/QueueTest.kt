import org.junit.jupiter.api.Test
import kotlin.test.assertNull
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class QueueTest {

    @Test
    fun enqueue() {
        val queue = Queue<Int>()
        queue.enqueue(1)
        assertEquals(1, queue.peek())
        queue.enqueue(2)
        assertEquals(1, queue.peek())
    }

    @Test
    fun dequeue() {
        val queue = Queue<Int>()
        assertNull(queue.dequeue())
        queue.enqueue(1)
        assertEquals(1, queue.dequeue())
        assertNull(queue.dequeue())
    }

    @Test
    fun peek() {
        val queue = Queue<Int>()
        assertNull(queue.peek())
        queue.enqueue(1)
        assertEquals(1, queue.peek())
        queue.enqueue(2)
        assertEquals(1, queue.peek())
    }

    @Test
    fun isEmpty() {
        val queue = Queue<String>()
        assertTrue(queue.isEmpty())
    }
}