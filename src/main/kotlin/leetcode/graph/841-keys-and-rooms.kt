package leetcode.graph

import java.util.*

class KeysAndRooms {

    private fun dfs(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)

        fun check(room: Int) {
            visited[room] = true
            for (v in rooms[room]) {
                if (!visited[v]) check(v)
            }
        }
        check(0)
        return visited.all { it }
    }

    private fun bfs(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size)
        val queue = LinkedList<Int>()
        queue.add(0)
        while (queue.isNotEmpty()) {
            val front = queue.remove()
            visited[front] = true
            for (v in rooms[front]) {
                if (!visited[v]) queue.add(v)
            }
        }
        return visited.all { it }
    }

    private fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        return dfs(rooms)
    }

    operator fun invoke(rooms: List<List<Int>>): Boolean {
        return canVisitAllRooms(rooms)
    }
}