package util

/**
 * Swap two elements at index [i] and [j] of an [IntArray]
 */
fun IntArray.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}

fun<T> MutableList<T>.swap(i: Int, j: Int) {
    this[i] = this[j].also { this[j] = this[i] }
}

/**
 * Reverse elements from [start] to [end]
 */
fun IntArray.reverse(start: Int, end: Int) {
    var l = start
    var r = end
    while (l < r) swap(l++, r--)
}

/**
 * Reverse elements from [start] to the end of array
 */
fun IntArray.reverse(start: Int) {
    reverse(start, size-1)
}