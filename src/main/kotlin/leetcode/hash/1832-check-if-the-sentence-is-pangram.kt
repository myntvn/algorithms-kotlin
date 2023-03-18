package leetcode.hash

class CheckIfPangram {

    private fun check(sentence: String) = sentence.toHashSet().size == 26

    fun test() {
        val s = "thequickbrownfoxjumpsoverthelazydog"
        println(check(s))
    }

}