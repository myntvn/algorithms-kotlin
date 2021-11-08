package leetcode.other

import util.reverse
import util.swap

class NextPermutation {
    private fun nextPermutation(nums: IntArray) {
        var i = nums.size-2
        while (i >= 0 && nums[i] >= nums[i+1]) --i
        if (i >= 0) {
            var j = nums.size-1
            while (j > i && nums[j] <= nums[i]) --j
            nums.swap(i, j)
        }
        nums.reverse(i+1)
    }

    operator fun invoke(nums: IntArray) {
        nextPermutation(nums)
    }
}