package algorithms.sort

/**
 * Сортировка пузырьком (Bubble Sort).
 *
 * Простейший алгоритм сортировки, использующий сравнение соседних элементов и их обмен в случае, если они расположены
 * не в порядке возрастания. Эффективен лишь для небольших массивов.
 *
 * Алгоритм состоит из повторяющихся проходов по сортируемому массиву. За каждый проход элементы последовательно
 * сравниваются попарно и, если порядок в паре неверный, выполняется перестановка элементов. Проходы по массиву
 * повторяются N-1 раз или до тех пор, пока на очередном проходе не окажется, что обмены больше не нужны.
 * При каждом проходе алгоритма по внутреннему циклу очередной наибольший элемент массива ставится на своё место
 * в конце массива рядом с предыдущим «наибольшим элементом».
 *
 * Время: среднее, максимальное – O(n²)
 * Память: 0(1)
 */

fun main() {
    val array = IntArray(10) { (1..20).random() }
    println(array.contentToString())

    val result = bubbleSort(array)
    println("The array was bubble sorted to: \n${result.contentToString()}.")
}

fun bubbleSort(arr: IntArray): IntArray {
    var len = arr.size
    val arrSorted = arr.copyOf()

    while (len != 0) {
        var lenSorted = 0
        for (i in 1 until len) {
            if (arrSorted[i - 1] > arrSorted[i]) {
                val temp = arrSorted[i - 1]
                arrSorted[i - 1] = arrSorted[i]
                arrSorted[i] = temp
                lenSorted = i
            }
        }
        len = lenSorted
    }
    return arrSorted
}