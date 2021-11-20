package leetcode.graph

class NumberOfProvinces {

    private fun dfs(graph: Array<IntArray>): Int {
        val n = graph.size
        var res = 0
        val visited = BooleanArray(n)

        fun dfs(start: Int) {
            visited[start] = true
            for (i in 0 until n) {
                if (!visited[i] && graph[start][i] == 1) dfs(i)
            }
        }

        for (i in 0 until n) {
            if (!visited[i]) {
                ++res
                dfs(i)
            }
        }

        return res
    }

    private fun unionFind(graph: Array<IntArray>): Int {
        val n = graph.size
        val parent = (0 until n).toList().toIntArray()
        graph.forEachIndexed { i, row ->
            row.forEachIndexed { j, isEdge ->
                if (isEdge == 1) {
                    val x = findParent(parent, i)
                    val y = findParent(parent, j)
                    if (x != y) parent[x] = y
                }
            }
        }

        // return parent.filterIndexed { index, v -> index == v }.size

        var res = 0
        parent.forEachIndexed { i, v -> if (i == v) ++res }
        return res
    }

    private fun findParent(parent: IntArray, v: Int): Int {
        if (parent[v] == v) return v
        return findParent(parent, parent[v])
    }

    private fun findCircleNum(graph: Array<IntArray>): Int {
        // return dfs(graph)
        return unionFind(graph)
    }

    operator fun invoke(graph: Array<IntArray>): Int {
        return findCircleNum(graph)
    }
}