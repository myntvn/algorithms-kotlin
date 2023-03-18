package leetcode.array

class TargetArrayInGivenOrder {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val res = arrayListOf<Int>()
        for (i in nums.indices) res.add(index[i], nums[i])
        return res.toIntArray()
    }

    fun test() {
        val nums = intArrayOf(0,1,2,3,4)
        val index = intArrayOf(0,1,2,2,1)
        for (i in createTargetArray(nums, index)) print("$i ")
    }
}