package leetcode.graph

class LoudAndRich {

    private fun dfs(graph: Array<MutableList<Int>>, quiet: IntArray, visited: BooleanArray, start: Int): Pair<Int, Int> {
        var x = start
        var y = quiet[start]
        for (v in graph[start]) {
            if (!visited[v]) {
                visited[v] = true
                if (quiet[v] < y) {
                    y = quiet[v]
                    x = v
                }
                val (newX, newY) = dfs(graph, quiet, visited, v)
                if (newY < y) {
                    x = newX
                    y = newY
                }
            }
        }
        return Pair(x, y)
    }

    private fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        val n = quiet.size
        val graph = Array<MutableList<Int>>(n) { mutableListOf() }
        richer.forEach {
            graph[it[1]].add(it[0])
        }

        val res = IntArray(n)

        for (i in 0 until n) {
            res[i] = dfs(graph, quiet, BooleanArray(n), i).first
        }

        return res
    }

    operator fun invoke(richer: Array<IntArray>, quiet: IntArray): IntArray {
        return loudAndRich(richer, quiet)
    }
}