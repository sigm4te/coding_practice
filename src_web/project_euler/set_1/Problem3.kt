package project_euler.set_1

import project_euler.utils.isPrime
import kotlin.math.max
import kotlin.math.sqrt

/**
 * Largest prime factor. / Наибольший простой делитель.
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * Простые делители числа 13195 – это 5, 7, 13 и 29.
 * Каков самый большой делитель числа 600851475143, являющийся простым числом?
 */

fun main() {
    val number = 600_851_475_143L

    // i * j = 600_851_475_143; Так как проверяем и i, и j, то максимальное значение i = SQRT(600_851_475_143)
    val limit = sqrt(number.toDouble()).toLong()
    var result = 0L

    for (i in (1..limit).filter { number % it == 0L }) {
        val j = number / i
        // Проверка делителя
        if (isPrime(i)) result = max(i, result)
        // Проверка частного
        if (isPrime(j)) result = max(j, result)
    }
    println("The largest prime factor of $number is $result.")
}