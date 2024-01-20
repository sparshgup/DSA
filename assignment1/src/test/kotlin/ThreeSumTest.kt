import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ThreeSumTest {
    @Test
    // Test normal triplets
    fun testTriplets() {
        // Test 1
        val nums1: IntArray = intArrayOf(1, 1, 0, -1, -2)
        val result1 = threeSum(nums1)
        val correctResult1 = listOf(listOf(-2, 1, 1), listOf(-1, 0, 1))
        assertEquals(correctResult1, result1)

        // Test 2
        val nums2: IntArray = intArrayOf(-1, 0, 1, 2, -1, 4)
        val result2 = threeSum(nums2)
        val correctResult2 = listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))
        assertEquals(correctResult2, result2)

        // Test 3
        val nums3: IntArray = intArrayOf(-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6)
        val result3 = threeSum(nums3)
        val correctResult3 = listOf(
            listOf(-4, -2, 6),
            listOf(-4, 0, 4),
            listOf(-4, 1, 3),
            listOf(-4, 2, 2),
            listOf(-2, -2, 4),
            listOf(-2, 0, 2)
        )
        assertEquals(correctResult3, result3)
    }

    @Test
    // Test duplicates
    fun testDuplicates() {
        val nums: IntArray = intArrayOf(-1, 0, -1, 0, 1)
        val result = threeSum(nums)
        val correctResult = listOf(listOf(-1, 0, 1))
        assertEquals(correctResult, result)
    }

    @Test
    // Test empty IntArray input
    fun testEmptyInput() {
        val nums: IntArray = intArrayOf()
        val result = threeSum(nums)
        val correctResult = emptyList<List<Int>>()
        assertEquals(correctResult, result)
    }

    @Test
    fun testNoTriplets() {
        val nums: IntArray = intArrayOf(1, 2, 3, 4)
        val result = threeSum(nums)
        val correctResult = emptyList<List<Int>>()
        assertEquals(correctResult, result)
    }
}