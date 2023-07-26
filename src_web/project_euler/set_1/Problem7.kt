package project_euler.set_1

import project_euler.utils.isPrime

/**
 * 10001st prime. / 10001-ое простое число.
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10001st prime number?
 *
 * Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13. Видно, что 6-ое простое число – 13.
 * Какое число является 10001-ым простым числом?
 */

fun main() {
    val counterResult = 10_001

    var counter = 0
    var number = 1

    while (counter < counterResult) {
        if (isPrime(++number)) counter++
    }
    println("The 10001-st prime number is $number.")
}