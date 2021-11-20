package leetcode.graph

import java.util.*

class KeysAndRooms {

    private fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
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
        return visited.count { it } == rooms.size
    }

    operator fun invoke(rooms: List<List<Int>>): Boolean {
        return canVisitAllRooms(rooms)
    }
}