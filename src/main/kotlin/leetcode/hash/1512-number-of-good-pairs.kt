package leetcode.hash

class NumberOfGoodPairs {

    private fun arraySolution(arr: IntArray): Int{
        var res = 0
        val c = IntArray(101)
        for (i in arr) {
            res += c[i]
            c[i]++
        }
        return res
    }

    private fun mapSolution(arr: IntArray): Int {
        var res = 0
        val m = mutableMapOf<Int, Int>()
        for (i in arr) {
            res += m.getOrDefault(i, 0)
            m[i] = m.getOrDefault(i, 0) + 1
        }
        return res
    }

    fun test() {
        val arr = intArrayOf(1, 2, 3, 1, 1, 3)
        println(mapSolution(arr)) // print 4
        println(arraySolution(arr)) // print 4
    }
}