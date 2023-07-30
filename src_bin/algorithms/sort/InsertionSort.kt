package algorithms.sort

/**
 * Сортировка вставками (Insertion Sort).
 *
 * Алгоритм сортировки.
 *
 * Элементы входной последовательности просматриваются по одному, и каждый новый поступивший элемент размещается
 * в подходящее место среди ранее упорядоченных элементов.
 *
 * Время: среднее, максимальное – O(n²)
 * Память: 0(1)
 */

fun main() {
    val array = IntArray(10) { (1..20).random() }
    println(array.contentToString())

    val result = insertionSort(array)
    println("The array was insertion sorted to: \n${result.contentToString()}.")
}

fun insertionSort(arr: IntArray): IntArray {
    val len = arr.size
    val arrSorted = arr.copyOf()

    for (i in 1 until len) {
        var j = i
        while (j > 0 && arrSorted[j - 1] > arrSorted[j]) {
            val temp = arrSorted[j - 1]
            arrSorted[j - 1] = arrSorted[j]
            arrSorted[j] = temp
            j--
        }
    }
    return arrSorted
}