package leetcode.bitmask

import java.util.*

class ShortestPathVisitingAllNodes {
    private fun shortestPathLength(graph: Array<IntArray>): Int {
        val n = graph.size
        val qu: Queue<Pair<Int, Int>> = LinkedList()
        val steps: Array<IntArray> = Array(n) { IntArray(1 shl n) { n * n } }
        for (i in 0 until n) {
            qu.add(Pair(i, 1 shl i))
            steps[i][1 shl i] = 0
        }
        val goal = (1 shl n) - 1
        while (qu.isNotEmpty()) {
            val (currentNode, currentPath) = qu.remove()
            val currentStep = steps[currentNode][currentPath]
            if (currentPath == goal) return currentStep
            for (e in graph[currentNode]) {
                val newStep = currentPath or (1 shl e)
                if (steps[e][newStep] > currentStep + 1) {
                    steps[e][newStep] = currentStep + 1
                    qu.add(Pair(e, newStep))
                }
            }
        }

        return n
    }

    fun test() {
        val graph = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(0),
            intArrayOf(0),
            intArrayOf(0)
        )

        println(shortestPathLength(graph))
    }
}