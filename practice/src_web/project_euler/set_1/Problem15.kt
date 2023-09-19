package project_euler.set_1

import java.math.BigInteger

/**
 * Lattice paths. / Пути через таблицу.
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down,
 * there are exactly 6 routes to the bottom right corner.
 * How many such routes are there through a 20×20 grid?
 *
 * Начиная в левом верхнем углу сетки 2×2 и имея возможность двигаться только вниз или вправо,
 * существует ровно 6 маршрутов до правого нижнего угла сетки.
 * Сколько существует таких маршрутов в сетке 20×20?
 */

fun main() {
    val sizeX = 20L
    val sizeY = 20L

    // routes = (x + y)! / (x! * y!)
    val counter = factorial(sizeX + sizeY) / factorial(sizeX).multiply(factorial(sizeY))
    println("The $sizeX×$sizeY grid has $counter routes.")
}

fun factorial(n: Long): BigInteger {
    var result = BigInteger.valueOf(1)
    for (i in 2..n) {
        result = result.multiply(BigInteger.valueOf(i))
    }
    return result
}