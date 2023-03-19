package leetcode.dp


class Largest1BorderSquare {

    private fun largest1BorderedSquare(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid.first().size

        val hor = Array(m) { IntArray(n) { 0 } }
        val ver = Array(m) { IntArray(n) { 0 } }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) continue
                hor[i][j] = grid[i][j]
                ver[i][j] = grid[i][j]
                if (j - 1 >= 0) hor[i][j] += hor[i][j - 1]
                if (i - 1 >= 0) ver[i][j] += ver[i - 1][j]
            }
        }

        var res = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                var len = hor[i][j].coerceAtMost(ver[i][j])
                while (len > res) {
                    if (hor[i - len + 1][j] >= len && ver[i][j - len + 1] >= len) {
                        res = len
                    }
                    --len
                }
            }
        }

        return res * res
    }

    operator fun invoke(grid: Array<IntArray>): Int {
        return largest1BorderedSquare(grid)
    }
}