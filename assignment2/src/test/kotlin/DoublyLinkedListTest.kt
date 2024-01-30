import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

class DoublyLinkedListTest {

    @Test
    fun pushFront() {
        val list = DoublyLinkedList<String>()
        list.pushFront("Hello")
        assertEquals("Hello", list.peekFront())
    }

    @Test
    fun pushBack() {
        val list = DoublyLinkedList<String>()
        list.pushBack("World!")
        assertEquals("World!", list.peekBack())
    }

    @Test
    fun popFront() {
        val list = DoublyLinkedList<Int>()
        list.pushFront(2)
        list.pushFront(1)
        assertEquals(1, list.popFront())
        assertEquals(2, list.popFront())
        assertNull(list.popFront())
    }

    @Test
    fun popBack() {
        val list = DoublyLinkedList<Int>()
        list.pushBack(1)
        list.pushBack(2)
        Assertions.assertEquals(2, list.popBack())
        Assertions.assertEquals(1, list.popBack())
        assertNull(list.popFront())
    }

    @Test
    fun peekFront() {
        val list = DoublyLinkedList<String>()
        list.pushFront("Hello")
        assertEquals("Hello", list.peekFront())
    }

    @Test
    fun peekBack() {
        val list = DoublyLinkedList<String>()
        list.pushBack("World!")
        Assertions.assertEquals("World!", list.peekBack())
    }

    @Test
    fun isEmpty() {
        val list = DoublyLinkedList<Int>()
        assertTrue(list.isEmpty())
    }
}