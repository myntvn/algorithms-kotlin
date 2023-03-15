package leetcode.dfs

class NumberOfEnclaves {

    private fun numEnclaves(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size

        fun dfs(r: Int, c: Int) {
            if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) return
            grid[r][c] = 0
            dfs(r - 1, c)
            dfs(r + 1, c)
            dfs(r, c - 1)
            dfs(r, c + 1)
        }

        for (r in 0 until m) {
            dfs(r, 0)
            dfs(r, n - 1)
        }
        for (c in 0 until n) {
            dfs(0, c)
            dfs(m - 1, c)
        }

        var res = 0
        for (r in 1 until m - 1)
            for (c in 1 until n - 1)
                if (grid[r][c] == 1) ++res

        return res
    }

    operator fun invoke(grid: Array<IntArray>): Int {
        return numEnclaves(grid)
    }
}