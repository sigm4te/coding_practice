package calculations.recursion

/**
 * Факториал (Factorial).
 *
 * Функция, определённая на множестве неотрицательных целых чисел.
 * Факториал натурального числа n определяется как произведение всех натуральных чисел от 1 до n включительно.
 *
 * > 0! = 1
 * > 5! = 1 × 2 × 3 × 4 × 5 = 120
 */

fun main() {
    val number = readln().toInt()
    println("The factorial of $number is ${factorial(number)}.")
}

fun factorial(x: Int): Int =
    if (x == 1 || x == 0) {
        1
    } else {
        (x * factorial(x - 1))
    }