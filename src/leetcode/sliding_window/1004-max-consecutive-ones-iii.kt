package leetcode.sliding_window

class MaxConsecutiveOnesIII {
    private fun longestOnes(nums: IntArray, k: Int): Int {
        var left = 0
        var flip = k
        nums.forEachIndexed { i, num ->
            if (num == 0) --flip
            if (flip < 0) {
                if (nums[left] == 0) ++flip
                ++left
            }
        }

        return nums.size - left
    }

    operator fun invoke(nums: IntArray, k: Int): Int {
        return longestOnes(nums, k)
    }
}