package algorithms.search

/**
 * Двоичный (бинарный) поиск (Binary Search).
 *
 * Алгоритм поиска элемента в отсортированном массиве (векторе), использующий дробление массива на половины.
 *
 * Определяется значение элемента в середине структуры данных. Полученное значение сравнивается с ключом.
 * Если ключ меньше значения середины, то поиск осуществляется в первой половине элементов, иначе — во второй.
 * Поиск сводится к тому, что вновь определяется значение серединного элемента в выбранной половине и сравнивается с ключом.
 * Процесс продолжается до тех пор, пока не будет найден элемент со значением ключа или не станет пустым интервал для поиска.
 *
 * Время: среднее, максимальное – O(log n);
 * Память: O(1)
 */

fun main() {
    val arrSize = 1000
    val number = 199
    val array = IntArray(arrSize) { i -> i }

    val result = binarySearch(number, array)
    println("Number: ${if (result == -1) "not found" else result.toString()}.")
}

fun binarySearch(target: Int, array: IntArray): Int {
    var boundLow = 0
    var boundHigh = array.size - 1
    var counter = 0

    while (boundLow <= boundHigh) {
        val mid = (boundLow + boundHigh) / 2
        val midValue = array[mid]
        counter++

        if (target == midValue) {
            println("Steps: $counter")
            return mid
        } else if (target < midValue) {
            boundHigh = mid - 1
        } else {
            boundLow = mid + 1
        }
    }
    return -1
}