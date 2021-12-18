package leetcode.graph

import kotlin.math.min

class FindTheCityWithSmallestNeighbors {

    private fun findTheCity(n: Int, edges: Array<IntArray>, threshold: Int): Int {
        val graph = Array(n) { IntArray(n) { 10001 } }
        for (e in edges) {
            graph[e[0]][e[1]] = e[2]
            graph[e[1]][e[0]] = e[2]
        }

        val dp = Array(n) { IntArray(n) }

        for (i in 0 until n)
            for (j in 0 until n)
                dp[i][j] = graph[i][j]

        for (k in 0 until n)
            for (i in 0 until n)
                for (j in 0 until n)
                    if (i != j) dp[i][j] = min(dp[i][j], dp[i][k] + dp[k][j])

        var res = 0
        var count = Int.MAX_VALUE
        for (i in 0 until n) {
            var tmp = 0
            for (j in 0 until n)
                if (i != j && dp[i][j] <= threshold) ++tmp
            if (tmp <= count) {
                count = tmp
                res = i
            }
        }

        return res
    }

    operator fun invoke(n: Int, edges: Array<IntArray>, threshold: Int): Int {
        return findTheCity(n, edges, threshold)
    }
}