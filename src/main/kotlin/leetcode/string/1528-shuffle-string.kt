package leetcode.string

import java.lang.StringBuilder

class ShuffleString {
    fun method1(s: String, indices: IntArray): String {
        val res = StringBuilder(s)
        for (i in s.indices) {
            res[indices[i]] = s[i]
        }
        return res.toString();
    }

    fun method2(s: String, indices: IntArray): String {
        val res = s.toCharArray()
        for (i in s.indices) {
            res[indices[i]] = s[i]
        }
        return String(res);
    }
}
