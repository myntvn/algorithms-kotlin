package leetcode.graph

import java.util.ArrayDeque

class FindIfPathExistsInGraph() {

    private lateinit var graph: Array<MutableList<Int>>
    private lateinit var visited: BooleanArray

    private fun dfsRecursion(start: Int, end: Int): Boolean {
        if (start == end) return true
        for (v in graph[start]) {
            if (!visited[v]) {
                visited[v] = true
                if (dfsRecursion(v, end)) return true
            }
        }
        return false
    }

    private fun dfsLoop(start: Int, end: Int): Boolean {
        val stack = ArrayDeque<Int>()
        stack.push(start)
        while (stack.isNotEmpty()) {
            val top = stack.peek()
            if (top == end) return true
            stack.pop()
            visited[top] = true
            for (v in graph[top]) {
                if (!visited[v]) stack.push(v);
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
        //visited[start] = true
        return dfsLoop(start, end)
    }

    operator fun invoke(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        return validPath(n, edges, start, end)
    }
}