package leetcode.graph

class LoudAndRich {

    // Least quiet person's index
    var x = 0
    // Least quiet value
    var y = 0
    private fun dfs(graph: Array<MutableList<Int>>, quiet: IntArray, visited: BooleanArray, start: Int) {
        for (v in graph[start]) {
            if (!visited[v]) {
                visited[v] = true
                if (quiet[v] < y) {
                    y = quiet[v]
                    x = v
                }
                dfs(graph, quiet, visited, v)
            }
        }
    }

    private fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        val n = quiet.size
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }
        richer.forEach {
            graph[it[1]].add(it[0])
        }

        val res = IntArray(n)

        for (i in 0 until n) {
            x = i
            y = quiet[i]
            dfs(graph, quiet, BooleanArray(n), i)
            res[i] = x
        }

        return res
    }

    operator fun invoke(richer: Array<IntArray>, quiet: IntArray): IntArray {
        return loudAndRich(richer, quiet)
    }
}