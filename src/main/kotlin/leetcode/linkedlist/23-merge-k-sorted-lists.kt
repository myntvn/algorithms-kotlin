package leetcode.linkedlist

import java.util.*
import kotlin.Comparator


class MergeKSortedLists {

    private fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val compare: Comparator<Pair<Int, ListNode?>> = compareBy { it.first }
        val pq = PriorityQueue<Pair<Int, ListNode?>>(compare)

        lists.forEach {
            it?.let { list ->
                pq.add(Pair(list.`val`, list.next))
            }
        }
        var head: ListNode? = null
        var p: ListNode? = null
        while (pq.isNotEmpty()) {
            val top = pq.poll()
            if (head == null) {
                head = ListNode(top.first)
                p = head
            } else {
                p?.next = ListNode(top.first)
                p = p?.next
            }
            top.second?.let { node ->
                pq.add(Pair(node.`val`, node.next))
            }
        }

        return head
    }

    operator fun invoke(lists: Array<ListNode?>): ListNode? {
        return mergeKLists(lists)
    }
}