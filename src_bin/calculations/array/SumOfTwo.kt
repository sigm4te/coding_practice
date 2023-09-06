package calculations.array

/**
 * Сумма двух элементов (Sum of Two).
 *
 * Позволяет найти два числа из отсортированного массива, сумма которых равна заданному числу.
 */

fun main() {
    val num = 6
    val array = List(10) { (-10..10).random() }
        .distinctBy { it }
        .toIntArray()
        .sortedArray()
    println(array.contentToString())
    println("$num is sum of elements: ${sumOfTwo(array, num).joinToString(", ")}")
}

// Метод двух указателей
fun sumOfTwo(arr: IntArray, target: Int): IntArray {
    var left = 0
    var right = arr.size - 1
    while (left < right) {
        val sum = arr[left] + arr[right]
        if (sum == target) {
            return intArrayOf(arr[left], arr[right])
        } else if (sum < target) {
            left++
        } else {
            right--
        }
    }
    return intArrayOf()
}