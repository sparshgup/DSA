/**
 * Given a binary search tree, find the closest elements to a query.
 * Leetcode Problem: https://leetcode.com/problems/closest-nodes-queries-in-a-binary-search-tree/submissions/1221684079/
 */
class closestNodesSolution {
    fun closestNodes(root: TreeNode?, queries: List<Int>): List<List<Int>> {
        val sortedVal = mutableListOf<Int>()
        inorder(root, sortedVal)

        fun getClosestPair(query: Int): List<Int> {
            val i = sortedVal.binarySearch(query)
            if (i >= 0) {
                return listOf(query, query)
            }
            val insertionPoint = -(i + 1)
            val closestSmaller = if (insertionPoint > 0) sortedVal[insertionPoint - 1] else -1
            val closestLarger = if (insertionPoint < sortedVal.size) sortedVal[insertionPoint] else -1
            return listOf(closestSmaller, closestLarger)
        }

        return queries.map { getClosestPair(it) }
    }

    private fun inorder(root: TreeNode?, sortedVal: MutableList<Int>) {
        if (root == null) return
        inorder(root.left, sortedVal)
        sortedVal.add(root.`val`)
        inorder(root.right, sortedVal)
    }

}