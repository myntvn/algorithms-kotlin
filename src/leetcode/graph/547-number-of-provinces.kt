package leetcode.graph

class NumberOfProvinces {

    private fun findCircleNum(graph: Array<IntArray>): Int {
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

    operator fun invoke(graph: Array<IntArray>): Int {
        return findCircleNum(graph)
    }
}