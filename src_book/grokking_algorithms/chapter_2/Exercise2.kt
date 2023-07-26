package grokking_algorithms.chapter_2

/** Chapter 2. Selection Sort */

fun main() {
    val array = IntArray(10) { (1..20).random() }

    println("Original array:\t ${array.contentToString()}.")
    println("Sorted array:\t ${selectionSort(array).contentToString()}.")
}

// Selection Sort
fun selectionSort(array: IntArray): IntArray {
    var unsortedArray = array.copyOf()
    val sortedArray = IntArray(unsortedArray.size)

    for (i in sortedArray.indices) {
        // Добавление наименьшего числа в сортированный массив
        val indexOfSmallest = findIndexOfSmallest(unsortedArray)
        sortedArray[i] = unsortedArray[indexOfSmallest]
        // Удаление наименьшего числа из несортированного массива
        unsortedArray = (unsortedArray.copyOfRange(0, indexOfSmallest) +
                unsortedArray.copyOfRange(indexOfSmallest + 1, unsortedArray.size))
    }
    return sortedArray
}

fun findIndexOfSmallest(array: IntArray): Int {
    var indexOfSmallest = 0
    var smallest = array[0]

    array.forEachIndexed { index, element ->
        if (element < smallest) {
            indexOfSmallest = index
            smallest = element
        }
    }
    return indexOfSmallest
}