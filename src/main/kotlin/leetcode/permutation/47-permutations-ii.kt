package leetcode.permutation

import util.swap

class PermutationII {

    private val res: MutableList<List<Int>> = mutableListOf()

    private fun dfs(nums: IntArray, l: Int, r: Int) {
        if (l == r) {
            res.add(nums.toList())
            return
        }

        val st: HashSet<Int> = hashSetOf()
        for (i in l..r) {
            if (!st.contains(nums[i])) {
                st.add(nums[i])
                nums.swap(l, i);
                dfs(nums, l + 1, r)
                nums.swap(l, i);
            }
        }
    }

    private fun permuteUnique(nums: IntArray): List<List<Int>> {
        dfs(nums, 0, nums.size - 1)
        return res
    }

    operator fun invoke(nums: IntArray): List<List<Int>> = permuteUnique(nums)

}