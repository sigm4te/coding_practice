package grokking_algorithms.chapter_4

/** Chapter 4. Quick Sort */

fun main() {
    val array = IntArray(10) { (1..20).random() }

    println("The sum of ${array.contentToString()} is ${sumOfArray(array)}.")
    println("The max item of ${array.contentToString()} is ${maxItem(array)}.")
    println("The array ${array.contentToString()} was quick sorted to ${quickSort(array).contentToString()}.")
}

// Sum of Array Items
fun sumOfArray(array: IntArray): Int {
    val length = array.size

    return if (length == 1) {
        array[0]
    } else {
        array[length - 1] + sumOfArray(array.copyOf(length - 1))
    }
}

// Max Item of an Array
fun maxItem(array: IntArray): Int {
    val length = array.size

    return if (length == 1) {
        array[0]
    } else {
        val value = maxItem(array.copyOf(length - 1))
        if (array[length - 1] >= value) {
            array[length - 1]
        } else {
            value
        }
    }
}

// Quick Sort
fun quickSort(array: IntArray): IntArray {
    val length = array.size

    if (length <= 1) {
        return array
    } else {
        val pivot = array[0]
        var less = IntArray(length - 1)
        var greater = IntArray(length - 1)

        var j = 0
        var k = 0
        for (i in 1 until length) {
            if (array[i] <= pivot) {
                less[j] = array[i]
                j++
            } else {
                greater[k] = array[i]
                k++
            }
        }
        less = less.copyOf(j)
        greater = greater.copyOf(k)
        return quickSort(less) + pivot + quickSort(greater)
    }
}