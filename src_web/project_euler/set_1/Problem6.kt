package project_euler.set_1

/**
 * Sum square difference. / Разность суммы квадратов и квадрата суммы.
 *
 * The sum of the squares of the first ten natural numbers is, 1² + 2² + ... + 10² = 385.
 * The square of the sum of the first ten natural numbers is, (1 + 2 + ... + 10)² = 55² = 3025.
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum
 * is 3025 – 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 *
 * Сумма квадратов первых десяти натуральных чисел равна: 1² + 2² + ... + 10² = 385.
 * Квадрат суммы первых десяти натуральных чисел равен: (1 + 2 + ... + 10)² = 55² = 3025.
 * Следовательно, разность между суммой квадратов и квадратом суммы первых десяти натуральных чисел составляет
 * 3025 – 385 = 2640.
 * Найдите разность между суммой квадратов и квадратом суммы первых ста натуральных чисел.
 */

fun main() {
    val number = 100

    var a = 0
    var b = 0

    for (i in 1..number) {
        // Сумма квадратов
        a += i * i
        // Сумма
        b += i
    }
    // Квадрат суммы
    b *= b
    println("The difference is ${b - a}.")
}