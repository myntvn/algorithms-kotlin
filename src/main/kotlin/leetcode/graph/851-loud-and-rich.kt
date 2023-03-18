package leetcode.graph

class LoudAndRich {

    private lateinit var res: IntArray
    private lateinit var graph: Array<MutableList<Int>>
    private lateinit var quiet: IntArray
    private fun dfs(node: Int): Int {
        if (res[node] != -1) return res[node]
        res[node] = node
        for (v in graph[node]) {
            val x = dfs(v)
            if (quiet[x] < quiet[res[node]]) res[node] = x
        }
        return res[node]
    }

    private fun loudAndRich(richer: Array<IntArray>, quiet: IntArray): IntArray {
        val n = quiet.size
        graph = Array<MutableList<Int>>(n) { mutableListOf() }
        this.quiet = quiet
        richer.forEach {
            graph[it[1]].add(it[0])
        }
        res = IntArray(n) { -1 }
        for (i in 0 until n) dfs(i)
        return res
    }

    operator fun invoke(richer: Array<IntArray>, quiet: IntArray): IntArray {
        return loudAndRich(richer, quiet)
    }
}