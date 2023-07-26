package project_euler.utils

import kotlin.math.sqrt

// Является ли число Int простым
fun isPrime(x: Int): Boolean {
    val limit = sqrt(x.toDouble()).toInt()
    for (i in (2..limit).filter { x % it == 0 }) {
        return false
    }
    return true
}

// Является ли число Long простым
fun isPrime(x: Long): Boolean {
    val limit = sqrt(x.toDouble()).toLong()
    for (i in (2..limit).filter { x % it == 0L }) {
        return false
    }
    return true
}

// Является ли число палиндромом
fun isPalindromicNumber(number: Int): Boolean {
    val inputNumber = number.toString()
    val reversedNumber = inputNumber.reversed()
    return inputNumber == reversedNumber
}

// Найти все делители числа
fun findAllDivisors(number: Int): List<Int> {
    val divisors = mutableListOf<Int>()
    for (k in (1..number).filter { (number % it == 0) }) {
        divisors.add(k)
    }
    return divisors
}

// Найти количество делителей числа
fun findDivisorsAmount(number: Int): Int {
    val top = sqrt(number.toDouble()).toInt()
    var counter = 0
    for (k in (1..top).filter { number % it == 0 }) {
        counter += 2
    }
    if (top * top == number) counter--
    return counter
}