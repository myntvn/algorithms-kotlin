package util

import kotlin.math.floor
import kotlin.math.sqrt

object MathUtil {

    /** Check if [num] is a perfect square. */
    fun isPerfectSquare(num: Int): Boolean = with(sqrt(num.toDouble())) {
        floor(this) == this
    }

}