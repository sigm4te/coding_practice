package calculations.digit

/**
 * Счётчик цифр (Digits Counter).
 *
 * Выводит количество цифр в заданном числе.
 */

fun main() {
    val number = readln().toInt()
    val digits = IntArray(10) { it }
    println(digits.contentToString())

    val counter = countDigits(number)
    println(counter.contentToString())
}

fun countDigits(x: Int): IntArray {
    val digitCounter = IntArray(10) { 0 }
    var num = x

    while (num > 0) {
        val lastDigit = num % 10
        digitCounter[lastDigit] += 1
        num /= 10
    }
    return digitCounter
}