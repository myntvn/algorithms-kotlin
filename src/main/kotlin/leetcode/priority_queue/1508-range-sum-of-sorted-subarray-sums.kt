package leetcode.priority_queue

import java.util.*
import kotlin.Comparator

class RangeSumOfSortedSubarraySums {

    private fun rangeSum(nums: IntArray, n: Int, left: Int, right: Int): Int {
        val compare: Comparator<Pair<Int, Int>> = compareBy { it.first }
        val pq = PriorityQueue<Pair<Int, Int>>(compare)

        nums.forEachIndexed { index, num ->
            pq.add(Pair(num, index + 1))
        }

        var res = 0
        val mod = 1000000007

        for (i in 1..right) {
            val top = pq.poll()

            if (i >= left) res = (res + top.first) % mod

            if (top.second < n) {
                pq.add(
                    Pair(
                        top.first + nums[top.second],
                        top.second + 1
                    )
                )
            }
        }

        return res
    }

    operator fun invoke(nums: IntArray, n: Int, left: Int, right: Int): Int {
        return rangeSum(nums, n, left, right)
    }

}