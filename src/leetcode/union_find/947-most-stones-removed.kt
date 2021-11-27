package leetcode.union_find

class MostStonesRemovedWithSameRowOrColumn {

    val p = HashMap<Int, Int>()
    var count = 0

    private fun find(u: Int): Int {
        if (!p.containsKey(u)) p[u] = u
        if (u != p[u]) p[u] = find(p[u]!!)
        return p[u]!!
    }

    private fun unite(u: Int, v: Int) {
        val x = find(u)
        val y = find(v)
        if (x != y) {
            p[x] = y
            ++count
        }
    }

    private fun removeStones(stones: Array<IntArray>): Int {
        stones.forEach { stone ->
            unite(stone[0], stone[1].inv())
        }
        return stones.size - (p.size - count)
    }

    operator fun invoke(stones: Array<IntArray>): Int = removeStones(stones)
}