package util

/**
 * Swap two elements at index [i] and [j] of an [IntArray]
 */
fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}