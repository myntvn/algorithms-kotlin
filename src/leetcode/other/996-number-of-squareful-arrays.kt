package leetcode.other

import kotlin.math.sqrt

class NumberOfSquarefulArrays {

    private fun isPerfectSquare(a: Int, b: Int): Boolean {
        return with(sqrt((a + b).toDouble()).toInt()) {
            this * this == a + b
        }
    }

    private fun numSquarefulPerms(nums: IntArray, idx: Int = -1): Int {
        if (idx == nums.size - 1) return 1
        var res = 0
        val used = HashSet<Int>()
        for (i in idx + 1 until nums.size) {
            if (!used.contains(nums[i]) && (idx == -1 || isPerfectSquare(nums[idx], nums[i]))) {
                used.add(nums[i])
                nums[i] = nums[idx + 1].also { nums[idx + 1] = nums[i] }
                res += numSquarefulPerms(nums, idx + 1)
                nums[i] = nums[idx + 1].also { nums[idx + 1] = nums[i] }
            }
        }
        return res
    }

    operator fun invoke(nums: IntArray) {
        println(numSquarefulPerms(nums))
    }
}