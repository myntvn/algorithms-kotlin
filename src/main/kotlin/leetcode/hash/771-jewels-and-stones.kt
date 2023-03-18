package leetcode.hash

class JewelsAndStones {

    fun numJewelsInStones(jewels: String, stones: String): Int {
        val s = jewels.toSet()
        var res = 0
        for (c in stones) {
            if (s.contains(c)) res++
        }
        return res
    }

    fun test() {
        val jewels = "aA"
        val stones = "aAAbbbb"
        print(numJewelsInStones(jewels, stones))
    }

}