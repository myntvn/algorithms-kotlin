package leetcode.permutation

import util.swap

class Permutations {

    private val res: MutableList<MutableList<Int>> = mutableListOf()

    private fun dfs(arr: MutableList<Int>, l: Int, r: Int) {
        if (l == r) {
            res.add(arr.toMutableList())
            return
        }

        for (i in l..r) {
            arr.swap(l, i)
            dfs(arr, l + 1, r)
            arr.swap(l, i)
        }
    }

    private fun permute(nums: IntArray): List<List<Int>> {
        dfs(nums.toMutableList(), 0, nums.size - 1)
        return res
    }

    operator fun invoke(nums: IntArray): List<List<Int>> = permute(nums)
}