package project_euler.set_1

/**
 * Special Pythagorean triplet. / Особая тройка Пифагора.
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a² + b² = c².
 * For example, 3² + 4² = 9 + 16 = 25 = 5².
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * Тройка Пифагора - три натуральных числа a < b < c, для которых выполняется равенство a² + b² = c².
 * Например, 3² + 4² = 9 + 16 = 25 = 5².
 * Существует только одна тройка Пифагора, для которой a + b + c = 1000.
 * Найдите произведение abc.
 */

fun main() {
    val number = 1_000

    // Так как (i < j < k), а (i + j + k = 1000), то максимальное значение i = (1000 / 3)
    for (i in 1..(number / 3)) {
        // Так как (i < j < k), а (i + j + k = 1000), то максимальное значение j = (1000 / 2)
        for (j in (i + 1)..(number / 2)) {
            val k = number - i - j
            if (i * i + j * j == k * k) {
                println("The product abc is ${i * j * k}.")
                break
            }
        }
    }
}