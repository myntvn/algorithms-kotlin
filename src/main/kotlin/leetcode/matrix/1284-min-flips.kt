package leetcode.matrix

import kotlin.math.min

class MinNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {

    private var m = 0
    private var n = 0
    private lateinit var graph: Array<ArrayList<Int>>

    private fun flip(mat: IntArray, idx: Int) {
        mat[idx] = mat[idx].xor(1)
        graph[idx].forEach {
            mat[it] = mat[it].xor(1)
        }
    }

    private fun getMinFlips(mat: IntArray, idx: Int): Int {
        if (mat.sum() == 0) return 0
        if (idx == mat.size) return 10000

        // do not flip
        val x = getMinFlips(mat.copyOf(), idx + 1)

        // flip
        flip(mat, idx)
        val y = getMinFlips(mat.copyOf(), idx+1) + 1
        return min(x, y)
    }

    fun minFlips(mat: Array<IntArray>): Int {
        m = mat.size
        n = mat[0].size
        val arr = IntArray(m * n)
        graph = Array(m * n) { ArrayList<Int>() }
        mat.forEachIndexed { r, ints ->
            ints.forEachIndexed { c, num ->
                val i = r * n + c
                arr[i] = num
                if (c - 1 >= 0) graph[i].add(r * n + c - 1);
                if (c + 1 < n) graph[i].add(r * n + c + 1);
                if (r - 1 >= 0) graph[i].add((r - 1) * n + c);
                if (r + 1 < m) graph[i].add((r + 1) * n + c);
            }
        }

        val res = getMinFlips(arr, 0)
        return if (res >= 10000) -1 else res
    }

    fun test() {
        val mat: Array<IntArray> = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0)
        )

        println(minFlips(mat))
    }
}