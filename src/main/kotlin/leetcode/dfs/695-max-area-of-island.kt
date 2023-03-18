package leetcode.dfs

import kotlin.math.max

class MaxAreaOfIsland {

    private fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val visited = Array(m) { BooleanArray(n) }

        fun dfs(r: Int, c: Int): Int {
            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0 || visited[r][c]) return 0
            visited[r][c] = true
            return 1 + dfs(r - 1, c) + dfs(r + 1, c) + dfs(r, c - 1) + dfs(r, c + 1)
        }

        var res = 0
        for (r in 0 until m)
            for (c in 0 until n)
                res = max(res, dfs(r, c))

        return res
    }

    operator fun invoke(grid: Array<IntArray>): Int {
        return maxAreaOfIsland(grid)
    }
}