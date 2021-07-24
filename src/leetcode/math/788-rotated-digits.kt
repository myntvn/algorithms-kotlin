package leetcode.math

class RotatedDigits() {

    fun isValid(n: Int): Boolean {
        var valid = false
        var t = n
        while (t > 0) {
            val x = t%10
            if (x == 3 || x ==4 || x ==7) return false
            else if (x == 2 || x == 5 || x==6 || x==9) valid = true
            t /= 10
        }
        return valid
    }

    fun rotatedDigits(n: Int): Int {
        var res = 0
        for (i in 1..n) if (isValid(i)) ++res
        return res
    }

    fun test() {
        val n = 857
        println(rotatedDigits(n)) // 247
    }
}