package leetcode.dp

import kotlin.math.max

class MaximumAlternatingSubsequenceSum {
    fun maxAlternatingSum(nums: IntArray): Long {
        var even: Long = 0
        var odd: Long = 0
        for (i in nums) {
            even = max(even, odd + i)
            odd = even - i
        }
        return even
    }

    fun test() {
        val nums = intArrayOf(6,2,1,2,4,5)
        println(maxAlternatingSum(nums))
    }
}