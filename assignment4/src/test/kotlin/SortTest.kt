import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.random.Random

class SortTest {

    /**
     * Test cases for the heapSort method.
     */
    @Test
    fun testHeapSort() {
        val sort = Sort()

        // Test case 1: Sort an empty array
        val emptyArray = intArrayOf()
        sort.heapSort(emptyArray)
        assertArrayEquals(intArrayOf(), emptyArray)

        // Test case 2: Sort an array with one element
        val singleElementArray = intArrayOf(5)
        sort.heapSort(singleElementArray)
        assertArrayEquals(intArrayOf(5), singleElementArray)

        // Test case 3: Sort an array with multiple elements
        val unsortedArray = intArrayOf(5, 3, 8, 2, 1)
        sort.heapSort(unsortedArray)
        assertArrayEquals(intArrayOf(1, 2, 3, 5, 8), unsortedArray)

        // Test case 4: Sort a large array
        val largeArray = IntArray(1000) { Random.nextInt() }
        val sortedCopy = largeArray.copyOf()
        sortedCopy.sort()
        sort.heapSort(largeArray)
        assertArrayEquals(sortedCopy, largeArray)
    }

    /**
     * Test cases for the insertionSort method.
     */
    @Test
    fun testInsertionSort() {
        val sort = Sort()

        // Test case 1: Sort an empty array
        val emptyArray = intArrayOf()
        sort.insertionSort(emptyArray)
        assertArrayEquals(intArrayOf(), emptyArray)

        // Test case 2: Sort an array with one element
        val singleElementArray = intArrayOf(5)
        sort.insertionSort(singleElementArray)
        assertArrayEquals(intArrayOf(5), singleElementArray)

        // Test case 3: Sort an array with multiple elements
        val unsortedArray = intArrayOf(5, 3, 8, 2, 1)
        sort.insertionSort(unsortedArray)
        assertArrayEquals(intArrayOf(1, 2, 3, 5, 8), unsortedArray)

        // Test case 4: Sort a large array
        val largeArray = IntArray(1000) { Random.nextInt() }
        val sortedCopy = largeArray.copyOf()
        sortedCopy.sort()
        sort.insertionSort(largeArray)
        assertArrayEquals(sortedCopy, largeArray)
    }

    /**
     * Test cases for the quickSort method.
     */
    @Test
    fun testQuickSort() {
        val sort = Sort()

        // Test case 1: Sort an empty array
        val emptyArray = intArrayOf()
        sort.quickSort(emptyArray)
        assertArrayEquals(intArrayOf(), emptyArray)

        // Test case 2: Sort an array with one element
        val singleElementArray = intArrayOf(5)
        sort.quickSort(singleElementArray)
        assertArrayEquals(intArrayOf(5), singleElementArray)

        // Test case 3: Sort an array with multiple elements
        val unsortedArray = intArrayOf(5, 3, 8, 2, 1)
        sort.quickSort(unsortedArray)
        assertArrayEquals(intArrayOf(1, 2, 3, 5, 8), unsortedArray)

        // Test case 4: Sort a large array
        val largeArray = IntArray(1000) { Random.nextInt() }
        val sortedCopy = largeArray.copyOf()
        sortedCopy.sort()
        sort.quickSort(largeArray)
        assertArrayEquals(sortedCopy, largeArray)
    }

    /**
     * Test cases for the mergeSort method.
     */
    @Test
    fun testMergeSort() {
        val sort = Sort()

        // Test case 1: Sort an empty array
        val emptyArray = intArrayOf()
        sort.mergeSort(emptyArray)
        assertArrayEquals(intArrayOf(), emptyArray)

        // Test case 2: Sort an array with one element
        val singleElementArray = intArrayOf(5)
        sort.mergeSort(singleElementArray)
        assertArrayEquals(intArrayOf(5), singleElementArray)

        // Test case 3: Sort an array with multiple elements
        val unsortedArray = intArrayOf(5, 3, 8, 2, 1)
        sort.mergeSort(unsortedArray)
        assertArrayEquals(intArrayOf(1, 2, 3, 5, 8), unsortedArray)

        // Test case 4: Sort a large array
        val largeArray = IntArray(1000) { Random.nextInt() }
        val sortedCopy = largeArray.copyOf()
        sortedCopy.sort()
        sort.mergeSort(largeArray)
        assertArrayEquals(sortedCopy, largeArray)
    }
}
