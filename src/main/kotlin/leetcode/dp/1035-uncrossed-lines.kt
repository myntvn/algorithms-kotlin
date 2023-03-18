package leetcode.dp

import kotlin.math.max

interface UncrossedLines {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int
    fun test()
}

class UncrossedLinesMemo: UncrossedLines {

    private lateinit var memo: Array<IntArray>

    fun f(arr1: IntArray, arr2: IntArray, i: Int, j: Int): Int {
        if (i == arr1.size || j == arr2.size) return 0
        if (memo[i][j] != -1) return memo[i][j]

        var res = 0
        for (k in i until arr1.size) {
            var count = 0
            count += if (arr1[k] == arr2[j]) 1 + f(arr1, arr2, k + 1, j + 1)
            else f(arr1, arr2, k, j + 1)
            res = max(res, count)
        }

        memo[i][j] = res
        return res
    }

    override fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        memo = Array(nums1.size) { IntArray(nums2.size) { -1 } }
        return f(nums1, nums2, 0, 0)
    }

    override fun test() {
        val nums1 = intArrayOf(1, 3, 7, 1, 7, 5)
        val nums2 = intArrayOf(1, 9, 2, 5, 1)
        println(maxUncrossedLines(nums1, nums2))
    }
}