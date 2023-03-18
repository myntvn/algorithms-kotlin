package leetcode.dp

import kotlin.math.max

class StoneGameVII {
    private lateinit var arr: IntArray
    private lateinit var dp: Array<IntArray>
    private fun dfs(sum: Int, left: Int, right: Int): Int {
        if (left == right) return 0
        if (dp[left][right] != 0) return dp[left][right]
        val removeLeft = sum - arr[left] - dfs(sum - arr[left], left + 1, right)
        val removeRight = sum - arr[right] - dfs(sum - arr[right] , left, right - 1)
        dp[left][right] = max(removeLeft, removeRight)
        return dp[left][right]
    }

    fun test(stones: IntArray): Int {
        arr = stones
        dp = Array(stones.size) { IntArray(stones.size) }
        return dfs(stones.sum(), 0, stones.size - 1)
    }
}