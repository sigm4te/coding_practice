package project_euler.set_1

import project_euler.utils.isPalindromicNumber
import kotlin.math.max

/**
 * Largest palindrome product. / Наибольшее произведение-палиндром.
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers
 * is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * Число-палиндром с обеих сторон читается одинаково. Наибольшее число-палиндром, полученное умножением двух двузначных
 * чисел, это 9009 = 91 × 99.
 * Найдите самый большой палиндром, полученный умножением двух трёхзначных чисел.
 */

fun main() {
    // Наименьшее и наибольшее трёхзначные числа
    val numberMin = 100
    val numberMax = 999

    var result = 0

    for (i in numberMin..numberMax) {
        // Нет смысла проверять произведения, в которых j < i
        for (j in i..numberMax) {
            val value = i * j
            if (isPalindromicNumber(value)) {
//                 // ↓ Вывод всех палиндромов ↓
//                 println(value)
                result = max(value, result)
            }
        }
    }
    println("The largest palindrome made from the product of two 3-digit numbers is $result.")
}