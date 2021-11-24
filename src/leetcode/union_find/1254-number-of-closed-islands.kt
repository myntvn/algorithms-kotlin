package leetcode.union_find

class NumberOfClosedIslands {
    var m = 0
    var n = 0

    private fun dfs(grid: Array<IntArray>, visited: Array<IntArray>, r: Int, c: Int): Boolean {
        if (r < 0 || r >= m || c < 0 || c >= n) return false
        if (grid[r][c] == 1) return true
        if (visited[r][c] == 1) return true
        if (visited[r][c] == 2) return false

        visited[r][c] = 1
        if (dfs(grid, visited, r - 1, c) && dfs(grid, visited, r + 1, c)
            && dfs(grid, visited, r, c - 1) && dfs(grid, visited, r, c + 1)
        ) return true
        visited[r][c] = 2
        return false
    }

    private fun closedIsland(grid: Array<IntArray>): Int {
        m = grid.size
        n = grid[0].size

        var res = 0
        val visited = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0 && visited[i][j] == 0) {
                    res += if (dfs(grid, visited, i, j)) 1 else 0
                }
            }
        }
        return res
    }

    operator fun invoke(grid: Array<IntArray>): Int {
        return closedIsland(grid)
    }
}