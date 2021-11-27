package leetcode.union_find

class MostStonesRemovedWithSameRowOrColumn {

    private fun find(p: IntArray, v: Int): Int {
        return if (p[v] == v) v else find(p, p[v])
    }

    private fun unite(p: IntArray, u: Int, v: Int) {
        p[find(p, u)] = find(p, v)
    }

    private fun dfs(graph: Array<MutableList<Int>>, p: IntArray, start: Int) {
        graph[start].forEach {
            if (find(p, it) != find(p, start)) {
                unite(p, it, start)
                dfs(graph, p, it)
            }
        }
    }

    private fun removeStones(stones: Array<IntArray>): Int {
        val n = stones.size
        val graph: Array<MutableList<Int>> = Array(n) { mutableListOf() }

        val xMap = HashMap<Int, MutableList<Int>>()
        val yMap = HashMap<Int, MutableList<Int>>()

        stones.forEachIndexed { idx, stone ->
            if (xMap[stone[0]] != null) xMap[stone[0]]!!.add(idx)
            else xMap[stone[0]] = mutableListOf(idx)

            if (yMap[stone[1]] != null) yMap[stone[1]]!!.add(idx)
            else yMap[stone[1]] = mutableListOf(idx)
        }

        stones.forEachIndexed { idx, stone ->
            xMap[stone[0]]?.let {
                it.forEach { point ->
                    if (point != idx) graph[idx].add(point)
                }
            }

            yMap[stone[1]]?.let {
                it.forEach { point ->
                    if (point != idx) graph[idx].add(point)
                }
            }
        }

        val p = (0 until n).toList().toIntArray()
        for (i in 0 until n) dfs(graph, p, i)

        var res = n
        p.forEachIndexed { idx, v ->
            if (idx == v) --res
        }

        return res
    }

    operator fun invoke(stones: Array<IntArray>): Int = removeStones(stones)
}