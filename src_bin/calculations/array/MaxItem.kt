package calculations.array

/**
 * Максимальный элемент массива (Max Item of Array)
 */

fun main() {
    val array = IntArray(10) { (1..20).random() }
    println(array.contentToString())
    println("The max item is ${maxItem(array)}.")
}

fun maxItem(arr: IntArray): Int {
    val len = arr.size

    return if (len == 1) {
        arr[0]
    } else {
        val value = maxItem(arr.copyOf(len - 1))
        if (arr[len - 1] >= value) {
            arr[len - 1]
        } else {
            value
        }
    }
}