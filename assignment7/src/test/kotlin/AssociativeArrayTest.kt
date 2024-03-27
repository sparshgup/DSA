import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class AssociativeArrayTest {

    /**
     * Tests if the set method correctly sets or updates key-value pairs.
     */
    @Test
    fun set() {
        val array = AssociativeArray<String, Int>()
        array["key1"] = 10
        assertEquals(10, array["key1"])
        array["key1"] = 20
        assertEquals(20, array["key1"])
    }

    /**
     * Tests if the contains method correctly checks for the existence of keys.
     */
    @Test
    fun contains() {
        val array = AssociativeArray<String, Int>()
        array["key1"] = 10
        array["key2"] = 20
        assertTrue("key1" in array)
        assertTrue("key2" in array)
        assertFalse("key3" in array)
    }

    /**
     * Tests if the get method correctly retrieves values associated with keys.
     */
    @Test
    fun get() {
        val array = AssociativeArray<String, Int>()
        array["key1"] = 10
        assertEquals(10, array["key1"])
        assertNull(array["nonexistent"])
    }

    /**
     * Tests if the remove method correctly removes key-value pairs.
     */
    @Test
    fun remove() {
        val array = AssociativeArray<String, Int>()
        array["key1"] = 10
        assertTrue(array.remove("key1"))
        assertFalse("key1" in array)
        assertFalse(array.remove("nonexistent"))
    }

    /**
     * Tests if the size method correctly returns the number of elements.
     */
    @Test
    fun size() {
        val array = AssociativeArray<String, Int>()
        array["key1"] = 10
        array["key2"] = 20
        assertEquals(2, array.size())
    }

    /**
     * Tests if the keyValuePairs method correctly returns a list of key-value pairs.
     */
    @Test
    fun keyValuePairs() {
        val array = AssociativeArray<String, Int>()
        array["key1"] = 10
        array["key2"] = 20
        val expected = listOf("key1" to 10, "key2" to 20)
        assertEquals(expected, array.keyValuePairs())
    }

    /**
     * Tests if the hash method correctly computes the hash value for a key.
     */
    @Test
    fun hash() {
        val array = AssociativeArray<String, Int>()
        assertEquals(15, array.hash("key"))
    }

    @Test
    fun rehash() {
        val array = AssociativeArray<Int, String>()

        // add elements
        for (i in 1..10) {
            array[i] = "Value $i"
        }
        assertEquals(10, array.size())
        assertEquals(16, array.capacity)

        // rehash
        array.rehash()
        assertEquals(37, array.capacity)

        // retrieve and verify the elements after rehashing
        for (i in 1..10) {
            assertEquals("Value $i", array[i])
        }
    }

    /**
     * Tests if the isPrime method correctly checks if a number is prime.
     */
    @Test
    fun isPrime() {
        val array = AssociativeArray<String, Int>()
        assertFalse(array.isPrime(1))
        assertTrue(array.isPrime(2))
        assertTrue(array.isPrime(5))
        assertFalse(array.isPrime(10))
        assertTrue(array.isPrime(17))
        assertFalse(array.isPrime(15))
    }

    /**
     * Tests if the nextPrime method correctly finds the next prime number greater than a given number.
     */
    @Test
    fun nextPrime() {
        val array = AssociativeArray<String, Int>()
        assertEquals(2, array.nextPrime(1))
        assertEquals(5, array.nextPrime(4))
        assertEquals(7, array.nextPrime(5))
    }
}