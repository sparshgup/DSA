/**
 * Leetcode Problem: https://leetcode.com/problems/range-sum-of-bst/description/
 */
class rangeSumBSTSolution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null) return 0

        var sum = 0
        if (root.`val` in low..high) {
            sum += root.`val`
        }
        if (root.`val` > low) {
            sum += rangeSumBST(root.left, low, high)
        }
        if (root.`val` < high) {
            sum += rangeSumBST(root.right, low, high)
        }

        return sum
    }
}