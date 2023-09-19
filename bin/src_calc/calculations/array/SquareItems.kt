package calculations.array

import kotlin.math.abs

/**
 * Квадрат элементов массива (Squared Items of Array).
 */

fun main() {
    val array = List(10) { (-10..10).random() }
        .distinctBy { it }
        .toIntArray()
        .sortedArray()
    println(array.contentToString())
    println(squareItems(array).contentToString())
}

// Метод двух указателей
fun squareItems(arr: IntArray): IntArray {
    val len = arr.size
    val squaredArr = IntArray(len)

    var left = 0
    var right = len - 1
    for (i in arr.indices) {
        val index = if (abs(arr[right]) >= abs(arr[left])) { right-- } else { left++ }
        squaredArr[len - 1 - i] = arr[index] * arr[index]
    }
    return squaredArr
}