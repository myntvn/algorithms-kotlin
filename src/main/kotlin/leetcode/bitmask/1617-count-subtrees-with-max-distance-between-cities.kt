package leetcode.bitmask

import kotlin.math.max
import kotlin.math.min

class CountSubtreesWithMaxDistanceBetweenCities {
    fun countSubgraphsForEachDiameter(n: Int, edges: Array<IntArray>): IntArray {
        val dp = Array(n) { IntArray(n) { n } }
        for (e in edges) {
            dp[e[0]-1][e[1]-1] = 1
            dp[e[1]-1][e[0]-1] = 1
        }

        for (k in 0 until n)
            for (i in 0 until n)
                for (j in 0 until n)
                    dp[i][j] = min(dp[i][j], dp[i][k]+dp[k][j])

        val res = IntArray(n-1)
        for (mask in 0 until (1 shl n)) {
            var eds = 0
            var maxDis = 0
            var nodes = 0
            for (i in 0 until n) {
                if (mask and (1 shl i) == 0) continue
                ++nodes
                for (j in i+1 until n) {
                    if (mask and (1 shl j) == 0) continue
                    eds += if (dp[i][j] == 1) 1 else 0
                    maxDis = max(maxDis, dp[i][j])
                }
            }
            if (eds > 0 && eds == nodes-1) ++res[maxDis-1]
        }

        return res
    }

    fun test() {
        val graph = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        countSubgraphsForEachDiameter(3, graph).forEach {
            print("$it ")
        }
    }
}