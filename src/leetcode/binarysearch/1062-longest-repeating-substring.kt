package leetcode.binarysearch

class LongestRepeatingSubstring {

    private fun repeat(s: String, length: Int): Boolean {
        val seen = HashSet<String>()

        for (i in 0 until s.length-length+1) {
            val str = s.substring(i, i + length)
            if (seen.contains(str)) return true
            else seen.add(str)
        }

        return false
    }

    private fun longestRepeatingSubstring(s: String) : Int {
        var left = 1
        var right = s.length - 1

        while (left <= right) {
            val mid = (right + left) / 2
            if (repeat(s, mid)) left = mid + 1
            else right = mid - 1
        }

        return left - 1
    }

    operator fun invoke(s: String): Int {
        return longestRepeatingSubstring(s)
    }
}