package grokking_algorithms.chapter_1

/** Chapter 1. Binary Search */

fun main() {
    val number = 199
    val array = IntArray(1000) { i -> i }

    val result = binarySearch(number, array)
    val resultString = if (result == -1) "not found" else result.toString()

    println("Number: $resultString.")
}

// Binary Search
fun binarySearch(number: Int, array: IntArray): Int {
    var low = 0
    var high = array.size - 1
    var counter = 0

    while (low <= high) {
        val mid = (low + high) / 2
        val guess = array[mid]
        counter++

        if (number == guess) {
            println("Steps: $counter")
            return mid
        } else if (number < guess) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return -1
}