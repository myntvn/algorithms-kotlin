package leetcode.graph

class NumberOfOperationsToMakeNetworkConnected {

    private fun dfs(graph: Array<MutableList<Int>>, visited: BooleanArray, start: Int) {
        visited[start] = true
        for (v in graph[start]) {
            if (!visited[v]) dfs(graph, visited, v)
        }
    }

    private fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) return -1

        val graph = Array(n) { mutableListOf<Int>() }
        for (e in connections) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }

        val visited = BooleanArray(n)
        var res = 0
        for (v in 0 until n) {
            if (!visited[v]) {
                ++res;
                dfs(graph, visited, v)
            }
        }

        return res - 1
    }

    operator fun invoke(n: Int, connections: Array<IntArray>): Int {
        return makeConnected(n, connections)
    }
}