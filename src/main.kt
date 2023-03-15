import leetcode.union_find.MostStonesRemovedWithSameRowOrColumn

fun main() {
    val stones = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(0, 1),
        intArrayOf(1, 0),
        intArrayOf(1, 2),
        intArrayOf(2, 1),
        intArrayOf(2, 2)
    )

    println(MostStonesRemovedWithSameRowOrColumn()(stones))

}
