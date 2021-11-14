package leetcode.graph

class FindIfPathExistsInGraph() {

    private lateinit var graph: Array<MutableList<Int>>
    private lateinit var visited: BooleanArray

    private fun dfs(start: Int, end: Int): Boolean {
        if (start == end) return true
        for (v in graph[start]) {
            if (!visited[v]) {
                visited[v] = true
                if (dfs(v, end)) return true
            }
        }
        return false
    }

    private fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        graph = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }
        visited = BooleanArray(n)
        visited[start] = true
        return dfs(start, end)
    }

    operator fun invoke(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        return validPath(n, edges, start, end)
    }
}