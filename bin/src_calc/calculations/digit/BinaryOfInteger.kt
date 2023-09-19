package calculations.digit

import kotlin.math.abs

/**
 * Двоичный код Integer (Binary of Integer).
 *
 * Выводит двоичное представление (big-endian) числа Signed Integer (от –31² до 31² – 1).
 */

fun main() {
    val number = readln().toInt()
    println(binaryOfInteger(number))
}

fun binaryOfInteger(x: Int): String {
    val size = Int.SIZE_BITS
    val numBin = StringBuilder()

    var numDec: Int
    val isNegative: Boolean
    if (x >= 0) {
        numDec = x
        isNegative = false
    } else {
        numDec = abs(x + 1)
        isNegative = true
    }

    while (numDec != 0) {
        numBin.append(numDec % 2)
        numDec /= 2
    }
    if (numBin.length < size) {
        while (numBin.length < size) { numBin.append(0) }
    }
    if (isNegative) {
        for (i in numBin.indices) { numBin[i] = reverseBit(numBin[i]) }
    }

    var i = size
    while (i > 0) {
        i -= 8
        numBin.insert(i, ' ')
    }
    return numBin.reverse().toString()
}

fun reverseBit(bit: Char): Char = if (bit == '0') '1' else '0'