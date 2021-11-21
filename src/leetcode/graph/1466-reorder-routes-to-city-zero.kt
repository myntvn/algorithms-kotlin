package leetcode.graph

import java.util.*

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 */
class ReorderRoutesToTheCityZero {

    private fun minReorder(n: Int, connections: Array<IntArray>): Int {
        val g1: Array<MutableList<Int>> = Array(n) { mutableListOf<Int>() }
        val g2: Array<MutableList<Int>> = Array(n) { mutableListOf<Int>() }

        connections.forEach { edge ->
            g1[edge[0]].add(edge[1])
            g2[edge[1]].add(edge[0])
        }

        val visited = BooleanArray(n)
        val st = Stack<Int>()
        st.push(0)
        var res = 0
        while (st.isNotEmpty()) {
            val top = st.pop()
            visited[top] = true
            for (v in g1[top]) {
                if (!visited[v]) {
                    ++res
                    st.push(v)
                }
            }
            for (v in g2[top])
                if (!visited[v]) st.push(v)
        }

        return res
    }

    operator fun invoke(n: Int, connections: Array<IntArray>): Int {
        return minReorder(n, connections)
    }
}