package calculations.array

/**
 * Префиксная сумма (Prefix Sum).
 *
 * Позволяет находить сумму элементов в середине массива как разность двух элементов массива префиксных сумм.
 */

fun main() {
    val left = 3
    val right = 8
    val array = IntArray(10) { (1..20).random() }
    println(array.contentToString())

    val prefixSumArray = makePrefixSumArray(array)
    println(prefixSumArray.contentToString())

    println("The sum of elements from $left to $right is ${rsq(prefixSumArray, left, right)}")
}

fun makePrefixSumArray(arr: IntArray): IntArray {
    val len = arr.size + 1
    val prefixSumArr = IntArray(len) { 0 }
    for (i in 1 until len) {
        prefixSumArr[i] = prefixSumArr[i - 1] + arr[i - 1]
    }
    return prefixSumArr
}

fun rsq(prefixSumArr: IntArray, left: Int, right: Int) = prefixSumArr[right] - prefixSumArr[left]