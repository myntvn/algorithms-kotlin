package leetcode.dp

class DifferentWayToAddParentheses {

    private lateinit var dp: Array<Array<ArrayList<Int>>>
    private fun cal(a: Int, b: Int, op: String): Int {
        return when (op) {
            "+" -> a + b
            "-" -> a - b
            else -> a * b
        }
    }

    private fun iterative(arr: List<String>) {
        for (i in arr.indices step 2) {
            dp[i][i].add(arr[i].toInt())
            for (j in i downTo 2) {
                for (k in i downTo j + 2) {
                    for (m in dp[i][k]) {
                        for (n in dp[k - 2][j]) {
                            dp[i][j].add(cal(n, m, arr[k - 1]))
                        }
                    }
                }

                for (m in dp[i][j]) {
                    for (n in dp[j-2][0]) {
                        dp[i][0].add(cal(n, m, arr[j-1]))
                    }
                }
            }
        }
    }

    fun diffWaysToCompute(express: String) : List<Int> {
        val arr = arrayListOf<String>()
        var d = ""
        for (c in express) {
            if (c in '0'..'9') {
                d += c
            } else {
                arr.add(d)
                arr.add(c.toString())
                d = ""
            }
        }
        arr.add(d)
        println(arr)
        dp = Array(arr.size) { Array(arr.size) { arrayListOf<Int>() } }
        iterative(arr)
        return dp[arr.size-1][0]
    }
}