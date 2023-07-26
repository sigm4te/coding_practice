package grokking_algorithms.chapter_3

/** Chapter 3. Recursion */

fun main() {
    val number = 7

    println("The factorial of $number is ${factorial(number)}.")
    println("The $number-th Fibonacci number is ${fibonacci(number)}.")
}

// Factorial
fun factorial(x: Int): Int =
    if (x == 1) {
        1
    } else {
        (x * factorial(x - 1))
    }

// Fibonacci
fun fibonacci(i: Int): Int =
    if (i == 0) {
        0
    } else if (i == 1) {
        1
    } else if (i > 1) {
        fibonacci(i - 1) + fibonacci(i - 2)
    } else {
        -1
    }