package leetcode.graph

class NumberOfOperationsToMakeNetworkConnected {

    private fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) return -1

        val graph = Array(n) { mutableListOf<Int>() }
        for (e in connections) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }

        val visited = BooleanArray(n)

        fun dfs(start: Int): Int {
            if (visited[start]) return 0
            visited[start] = true
            for (v in graph[start]) dfs(v)
            return 1
        }

        return (0 until n).sumOf { dfs(it) } - 1
    }

    operator fun invoke(n: Int, connections: Array<IntArray>): Int {
        return makeConnected(n, connections)
    }
}