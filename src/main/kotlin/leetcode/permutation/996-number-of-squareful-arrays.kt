package leetcode.other

import util.MathUtil.isPerfectSquare
import util.swap

class NumberOfSquarefulArrays {

    private fun numSquarefulPerms(nums: IntArray, idx: Int = -1): Int {
        if (idx == nums.size - 1) return 1
        var res = 0
        val used = HashSet<Int>()
        for (i in idx + 1 until nums.size) {
            if (!used.contains(nums[i]) && (idx == -1 || isPerfectSquare(nums[idx] + nums[i]))) {
                used.add(nums[i])
                nums.swap(i, idx + 1)
                res += numSquarefulPerms(nums, idx + 1)
                nums.swap(i, idx + 1)
            }
        }
        return res
    }

    operator fun invoke(nums: IntArray) {
        println(numSquarefulPerms(nums))
    }
}