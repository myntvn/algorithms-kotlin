package leetcode.binarytree

import leetcode.model.TreeNode
import kotlin.math.max

class FindLeavesOfBinaryTree {

    val res = mutableListOf<MutableList<Int>>()

    private fun getHeight(node: TreeNode?): Int {
        if (node == null) return -1
        val height = 1 + max(getHeight(node.left), getHeight(node.right))
        if (res.size == height) res.add(mutableListOf())
        res[height].add(node.`val`)
        return height
    }

    fun findLeaves(root: TreeNode?): List<List<Int>> {
        getHeight(root)
        return res
    }
}