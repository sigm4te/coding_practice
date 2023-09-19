package calculations.array

/**
 * Сумма элементов массива (Items Sum of Array).
 */

fun main() {
    val array = IntArray(10) { (1..20).random() }
    println(array.contentToString())
    println("The sum is ${itemsSum(array)}.")
}

fun itemsSum(arr: IntArray): Int {
    val len = arr.size

    return if (len == 1) {
        arr[0]
    } else {
        val newArr = arr.copyOf(len - 1)
        arr[len - 1] + itemsSum(newArr)
    }
}