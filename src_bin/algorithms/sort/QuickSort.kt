package algorithms.sort

/**
 * Быстрая сортировка (Quick Sort).
 *
 * Алгоритм сортировки, использующий разделение входной последовательности на массивы, большие и меньшие опорного элемента,
 * с их последующим рекурсивным разделением, пока размер этих массивов не достигнет 1.
 * Разработан английским информатиком Тони Хоаром в 1960-м году
 *
 * Из массива выбирается элемент, называемый опорным (pivot). Это может быть любой из элементов массива (от выбора
 * опорного элемента не зависит корректность алгоритма, но в отдельных случаях может сильно зависеть его эффективность).
 * Все остальные элементы сравниваются с опорным и переставляются в массиве так, чтобы разбить массив на три непрерывных
 * отрезка, следующих друг за другом: «элементы меньшие опорного», «равные» и «большие». Для отрезков «меньших» и «больших»
 * значений, если длина отрезка больше единицы, рекурсивно выполняется та же последовательность операций.
 *
 * Время: среднее – O(n×log n); максимальное – O(n²)
 * Память: 0(1)
 */

fun main() {
    val array = IntArray(10) { (1..20).random() }
    println(array.contentToString())

    val result = quickSort(array)
    println("The array was quick sorted to: \n${result.contentToString()}.")
}

fun quickSort(arr: IntArray): IntArray {
    val len = arr.size

    if (len <= 1) {
        return arr
    } else {
        val pivot = arr[0]
        var arrLess = IntArray(len - 1)
        var arrGreater = IntArray(len - 1)

        var iLess = 0
        var iGreater = 0
        for (i in 1 until len) {
            if (arr[i] <= pivot) {
                arrLess[iLess] = arr[i]
                iLess++
            } else {
                arrGreater[iGreater] = arr[i]
                iGreater++
            }
        }
        arrLess = arrLess.copyOf(iLess)
        arrGreater = arrGreater.copyOf(iGreater)
        return quickSort(arrLess) + pivot + quickSort(arrGreater)
    }
}