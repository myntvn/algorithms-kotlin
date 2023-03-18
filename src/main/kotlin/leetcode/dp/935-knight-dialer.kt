package leetcode.dp

class KnightDialer {
    private val mod = (1e9+7).toInt()
    private lateinit var neighbors: HashMap<Int, IntArray>
    private lateinit var dp: Array<IntArray>

    private fun dfs(count: Int, start: Int): Int {
        if (count == 0) return 1;
        if (dp[start][count] != -1) return dp[start][count]

        var res = 0
        for (i in neighbors[start]!!) {
            res += dfs(count-1, i)
            res %= mod
        }
        dp[start][count] = res
        return res
    }

    fun knightDialer(n: Int): Int {
        neighbors = hashMapOf(
            1 to intArrayOf(6, 8),
            2 to intArrayOf(7, 9),
            3 to intArrayOf(4, 8),
            4 to intArrayOf(9, 3, 0),
            5 to intArrayOf(),
            6 to intArrayOf(1, 7, 0),
            7 to intArrayOf(2, 6),
            8 to intArrayOf(1, 3),
            9 to intArrayOf(4, 2),
            0 to intArrayOf(4, 6)
        )

        dp = Array(10) { IntArray(n) { -1 } }

        var res = 0
        for (i in 0 until 10) {
            res += dfs(n-1, i)
            res %= mod
        }

        return res
    }

    operator fun invoke(n: Int): Int {
        return knightDialer(n)
    }
}


