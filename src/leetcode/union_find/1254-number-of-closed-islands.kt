package leetcode.union_find

class NumberOfClosedIslands {
    var m = 0
    var n = 0

    private fun dfs(grid: Array<IntArray>, r: Int, c: Int) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 1) return
        grid[r][c] = 1
        dfs(grid, r - 1, c)
        dfs(grid, r + 1, c)
        dfs(grid, r, c - 1)
        dfs(grid, r, c + 1)
    }

    private fun closedIsland(grid: Array<IntArray>): Int {
        m = grid.size
        n = grid[0].size

        for (i in 0 until m) {
            dfs(grid, i, 0)
            dfs(grid, i, n - 1)
        }
        for (i in 0 until n) {
            dfs(grid, 0, i)
            dfs(grid, m - 1, i)
        }

        var res = 0
        for (i in 1 until m - 1) {
            for (j in 1 until n - 1) {
                if (grid[i][j] == 0) {
                    ++res
                    dfs(grid, i, j)
                }
            }
        }
        return res
    }

    operator fun invoke(grid: Array<IntArray>): Int {
        return closedIsland(grid)
    }
}