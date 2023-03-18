package leetcode.dp

class KnightDialer {
    private val mod = (1e9+7).toInt()

    private val neighbors = hashMapOf(
        0 to intArrayOf(4, 6),
        1 to intArrayOf(6, 8),
        2 to intArrayOf(7, 9),
        3 to intArrayOf(4, 8),
        4 to intArrayOf(9, 3, 0),
        5 to intArrayOf(),
        6 to intArrayOf(1, 7, 0),
        7 to intArrayOf(2, 6),
        8 to intArrayOf(1, 3),
        9 to intArrayOf(4, 2),
    )

    private fun dfs(count: Int, start: Int, memo: Array<IntArray>): Int {
        if (count == 0) return 1;
        if (memo[start][count] != -1) return memo[start][count]

        var res = 0
        for (i in neighbors[start]!!) {
            res += dfs(count-1, i, memo)
            res %= mod
        }
        memo[start][count] = res
        return res
    }

    fun knightDialerMemoization(n: Int): Int {

        val memo = Array(10) { IntArray(n) { -1 } }

        var res = 0
        for (i in 0 until 10) {
            res += dfs(n-1, i, memo)
            res %= mod
        }

        return res
    }

    fun knightDialerDp(n: Int): Int {
        var dp = IntArray(10) { 1 }
        repeat(n-1) {
            val tmp = IntArray(10)
            for (i in 0 until 10) {
                neighbors[i]?.forEach {
                    tmp[i] += dp[it]
                    tmp[i] %= mod
                }
            }
            dp = tmp
        }

        var res = 0
        dp.forEach {
            res += it
            res %= mod
        }

        return res
    }

    operator fun invoke(n: Int): Int {
        return knightDialerDp(n)
    }
}


