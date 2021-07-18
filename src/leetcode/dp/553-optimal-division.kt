package leetcode.dp

class OptimalDivision {

    class D(
        val maxVal: Float,
        val minVal: Float,
        val maxStr: String,
        val minStr: String
    )

    private lateinit var memo: Array<Array<D?>>
    private fun findOptimalDivision(nums: IntArray, l: Int, r: Int): D {
        memo[l][r]?.let {
            return it
        }
        val res: D
        if (l == r) {
            res = D(
                nums[l].toFloat(),
                nums[r].toFloat(),
                nums[l].toString(),
                nums[l].toString()
            )
            memo[l][r] = res
            return res
        }

        var maxVal: Float = Float.MIN_VALUE
        var minVal: Float = Float.MAX_VALUE
        var maxStr = ""
        var minStr = ""
        for (i in l until r) {
            val x = findOptimalDivision(nums, l, i)
            val y = findOptimalDivision(nums, i + 1, r)
            with(x.maxVal / y.minVal) {
                if (this > maxVal) {
                    maxVal = this
                    maxStr = if (i + 1 == r) x.maxStr + "/" + y.minStr
                    else x.maxStr + "/(" + y.minStr + ")"
                }
            }
            with(x.minVal / y.maxVal) {
                if (this < minVal) {
                    minVal = this
                    minStr = if (i + 1 == r) x.minStr + "/" + y.maxStr
                    else x.minStr + "/(" + y.maxStr + ")"
                }
            }
        }

        res = D(maxVal, minVal, maxStr, minStr)
        memo[l][r] = res
        return res
    }

    fun optimalDivision(nums: IntArray): String {
        memo = Array(nums.size) { Array<D?>(nums.size) { null } }
        return findOptimalDivision(nums, 0, nums.size - 1).maxStr
    }

    fun test() {
        val nums = intArrayOf(1000, 100, 10, 2)
        println(optimalDivision(nums = nums))
    }


}