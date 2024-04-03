/**
 * Leetcode Problem: https://leetcode.com/problems/delete-node-in-a-bst/submissions/1221670908/
 */
class deleteNodeSolution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        if (key < root.`val`) {
            root.left = deleteNode(root.left, key)
        } else if (key > root.`val`) {
            root.right = deleteNode(root.right, key)
        } else {
            // case 1: node has no/one child
            if (root.left == null) return root.right
            if (root.right == null) return root.left

            // case 2: node has two children
            var successor = root.right
            while (successor?.left != null) {
                successor = successor.left
            }
            root.`val` = successor!!.`val`
            root.right = deleteNode(root.right, successor.`val`)
        }
        return root
    }
}