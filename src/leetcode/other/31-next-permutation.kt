package leetcode.other

import util.swap

class NextPermutation {
    private fun nextPermutation(nums: IntArray) {
        var i = nums.size-1
        while (i > 0) {
            if (nums[i-1] < nums[i]) {
                nums.sort(i)
                for (j in i until nums.size) {
                    if (nums[j] > nums[i-1]) {
                        nums.swap(i-1, j)
                        break;
                    }
                }
                break
            }
            --i
        }

        if (i == 0) nums.sort()
    }

    operator fun invoke(nums: IntArray) {
        nextPermutation(nums)
    }
}