package leetcode.graph

class FindIfPathExistsInGraph {

    fun dfs(graph: Array<MutableList<Int>>, visited: BooleanArray, start: Int, end: Int): Boolean {
        if (start == end) return true
        for (v in graph[start]) {
            if (!visited[v]) {
                visited[v] = true
                if (dfs(graph, visited, v, end)) return true
            }
        }
        return false
    }

    private fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        val graph: Array<MutableList<Int>> = Array(n) { mutableListOf<Int>() }
        for (e in edges) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }
        val visited = BooleanArray(n)
        visited[start] = true
        return dfs(graph, visited, start, end)
    }

    operator fun invoke(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        return validPath(n, edges, start, end)
    }
}