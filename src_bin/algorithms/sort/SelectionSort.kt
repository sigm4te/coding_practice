package algorithms.sort

/**
 * Сортировка выбором (Selection Sort).
 *
 * Алгоритм сортировки.
 *
 * Находится номер минимального значения в текущей последовательности. Производится обмен этого значения со значением
 * первой неотсортированной позиции (обмен не нужен, если минимальный элемент уже находится на данной позиции).
 * Далее сортируется хвост последовательности, исключив из рассмотрения уже отсортированные элементы.
 *
 * Время: среднее, максимальное – O(n²)
 * Память: 0(1)
 */

fun main() {
    val array = IntArray(10) { (1..20).random() }
    println(array.contentToString())

    val result = selectionSort(array)
    println("The array was selection sorted to: \n${result.contentToString()}.")
}

fun selectionSort(arr: IntArray): IntArray {
    var arrUnsorted = arr.copyOf()
    val arrSorted = IntArray(arrUnsorted.size)

    for (i in arrSorted.indices) {
        val iSmallest = findSmallestElement(arrUnsorted).first
        arrSorted[i] = arrUnsorted[iSmallest]
        arrUnsorted = (arrUnsorted.copyOfRange(0, iSmallest) + arrUnsorted.copyOfRange(iSmallest + 1, arrUnsorted.size))
    }
    return arrSorted
}

fun findSmallestElement(array: IntArray): Pair<Int, Int> {
    var iSmallest = 0
    var eSmallest = array[0]

    array.forEachIndexed { index, element ->
        if (element < eSmallest) {
            iSmallest = index
            eSmallest = element
        }
    }
    return (iSmallest to eSmallest)
}