/**
 * Leetcode Problem: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 */
class sortedArrayToBSTSolution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return sortedArrayToBSTHelper(nums, 0, nums.size - 1)
    }

    private fun sortedArrayToBSTHelper(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start > end) return null

        val mid = (start + end) / 2
        val root = TreeNode(nums[mid])

        root.left = sortedArrayToBSTHelper(nums, start, mid - 1)
        root.right = sortedArrayToBSTHelper(nums, mid + 1, end)

        return root
    }
}
