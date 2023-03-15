package leetcode.graph

import kotlin.math.max

class MaximalNetworkRank {

    private fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
        val count = IntArray(n)
        val graph = Array(n) { IntArray(n) }

        roads.forEach { road ->
            ++count[road[0]]
            ++count[road[1]]
            graph[road[0]][road[1]] = 1
            graph[road[1]][road[0]] = 1
        }

        var res = 0
        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                res = max(res, count[i] + count[j] - graph[i][j])
            }
        }
        return res
    }

    operator fun invoke(n: Int, roads: Array<IntArray>): Int {
        return maximalNetworkRank(n, roads)
    }
}