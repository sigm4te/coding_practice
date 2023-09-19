package project_euler.set_1

/**
 * Smallest multiple. / Наименьшее кратное.
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 * 2520 – наименьшее число, которое делится без остатка на все числа от 1 до 10.
 * Какое наименьшее число делится нацело на все числа от 1 до 20?
 */

fun main() {
    // Число не может быть меньше 2520
    var value = 2520
    var result = 0
    var isResult = false

    while (!isResult) {
        var divider = 1
        while (value % divider == 0) {
            if (divider == 20) {
                result = value
                isResult = true
                break
            }
            divider++
        }
        value++
    }
    println("The smallest positive number that is evenly divisible by all of the numbers from 1 to 20 is $result.")
}