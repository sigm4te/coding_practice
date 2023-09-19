package project_euler.set_1

/**
 * Longest Collatz sequence. / Самая длинная последовательность Коллатца.
 *
 * The following iterative sequence is defined for the set of positive integers:
 * n → n / 2 (n is even)
 * n → 3 × n + 1 (n is odd)
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although
 * it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 *
 * Следующая повторяющаяся последовательность определена для множества натуральных чисел:
 * n → n / 2 (n — чётное)
 * n → 3 × n + 1 (n — нечётное)
 * Используя описанное выше правило и начиная с 13, сгенерируется следующая последовательность:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * Получившаяся последовательность (начиная с 13 и заканчивая 1) содержит 10 элементов. Хотя это до сих пор
 * и не доказано (проблема Коллатца – Collatz Problem), предполагается, что все сгенерированные таким образом
 * последовательности оканчиваются на 1.
 * Какой начальный элемент меньше миллиона генерирует самую длинную последовательность?
 * Примечание: Следующие за первым элементы последовательности могут быть больше миллиона.
 */

fun main() {
    val numberLimit = 1_000_000

    var number = 13L
    var sequence = 10

    for (i in number..numberLimit) {
        var seq = 1
        var num = i

//         // ↓ Вывести последовательности для всех чисел ↓
//         do {
//             print("$num, ")
//             num = if (num % 2 == 0L) { num / 2 } else { 3 * num + 1 }
//         } while (num != 1L)
//         println("1.")

        do {
            if (num % 2 == 0L) {
                num /= 2
                seq += 1
            } else {
                num = (3 * num + 1) / 2
                seq += 2
            }
        } while (num != 1L)

        if (seq > sequence) {
            sequence = seq
            number = i
        }

//         // ↓ Вывести длину последовательностей для всех чисел ↓
//         println("Number is $i, chain is $seq.")
    }
    println("The longest chain: number is $number, chain is $sequence.")
}