package leetcode.graph

class FindEventualSafeStates {

    private lateinit var check: IntArray

    private fun dfs(graph: Array<IntArray>, start: Int): Boolean {
        if (check[start] != 0) return check[start] == 2

        check[start] = 1
        for (v in graph[start]) {
            if (!dfs(graph, v)) return false
        }
        check[start] = 2
        return true
    }

    private fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
        val n = graph.size
        check = IntArray(n)
        val res = mutableListOf<Int>()
        for (v in 0 until n) if (dfs(graph, v)) res.add(v)
        return res
    }

    operator fun invoke(graph: Array<IntArray>): List<Int> {
        return eventualSafeNodes(graph)
    }
}