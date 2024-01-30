import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class StackTest {

    @Test
    fun push() {
        val stack = Stack<Int>()
        stack.push(1)
        stack.push(2)
        assertEquals(2, stack.pop())
        assertEquals(1, stack.peek())
    }

    @Test
    fun pop() {
        val stack = Stack<String>()
        stack.push("Hello World!")
        assertEquals("Hello World!", stack.pop())
        assertNull(stack.pop())
    }

    @Test
    fun peek() {
        val stack = Stack<Int>()
        stack.push(1)
        assertEquals(1, stack.peek())
    }

    @Test
    fun isEmpty() {
        val stack = Stack<String>()
        assertTrue(stack.isEmpty())
    }
}