/**
 * Leetcode Problem: https://leetcode.com/problems/insert-into-a-binary-search-tree/submissions/1221678484/
 */
class insertIntoBSTSolution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode {
        if (root == null) return TreeNode(`val`)

        var next = root
        while (next != null) {
            if (`val` > next.`val`) {
                if (next.right == null) {
                    next.right = TreeNode(`val`)
                    break
                } else {
                    next = next.right
                }
            } else {
                if (next.left == null) {
                    next.left = TreeNode(`val`)
                    break
                } else {
                    next = next.left
                }
            }
        }
        return root
    }
}