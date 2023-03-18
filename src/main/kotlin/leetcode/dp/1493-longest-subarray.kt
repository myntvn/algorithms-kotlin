package leetcode.dp

import kotlin.math.max

class LongestSubArrOfOneAfterDelOneElement {
    fun longestSubarray(nums: IntArray): Int {
        val arr = arrayListOf<Int>()
        var count = 0
        for (i in nums) {
            if (i == 1) ++count
            else {
                arr.add(count)
                count = 0
            }
        }
        arr.add(count)
        if (arr.size == 1) return arr[0] - 1
        var res = 0
        for (i in 1 until arr.size) {
            res = max(res, arr[i] + arr[i - 1])
        }
        return res
    }

    fun test() {
        val nums = intArrayOf(1, 1, 0, 1)
        println(longestSubarray(nums))
    }
}