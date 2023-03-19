package leetcode.hash

class DividePlayers {

    private fun dividePlayers(skill: IntArray): Long {
        val n = skill.size
        val sum = skill.sum()
        if (sum % (n/2) != 0) return -1
        val target = sum*2/n

        val cnt: MutableMap<Int,Int> = hashMapOf()
        skill.forEach {
            cnt[it] = cnt.getOrDefault(it, 0) + 1
        }

        var res: Long = 0
        skill.forEach { s ->
            if (cnt[s] != 0) {
                if ((cnt[target - s] ?: 0) <= 0) return -1
                res += s*(target-s)
                cnt[s] = cnt[s]!! - 1
                cnt[target-s] = cnt[target-s]!! - 1
            }
        }

        return res
    }

    operator fun invoke(skill: IntArray): Long {
        return dividePlayers(skill)
    }
}