package bits

import kotlin.math.ceil
import kotlin.math.roundToInt

class CustomBitVector(size: Int) {
    private val intSize: Int = Int.SIZE_BITS
    private var vectorSize: Int = size
    private var amountInts: Int = ceil(vectorSize / intSize.toFloat()).roundToInt()
    private var vector: IntArray = IntArray(amountInts) { 0 }

    private fun getRow(bit: Int): Int = bit / intSize

    private fun getCol(bit: Int): Int = bit % intSize

    // Проверка бита
    fun isSetBit(index: Int): Boolean {
        return if (index in 0 until vectorSize) {
            val indexRow = getRow(index)
            val indexCol = getCol(index)
            (vector[indexRow] and (1 shl indexCol)) != 0
        } else {
            false
        }
    }

    // Установка бита в 1
    fun setBit(index: Int) {
        if (index in 0 until vectorSize) {
            val indexRow = getRow(index)
            val indexCol = getCol(index)
            vector[indexRow] = vector[indexRow] or (1 shl indexCol)
        }
    }

    // Установка бита в 0
    fun resetBit(index: Int) {
        if (index in 0 until vectorSize) {
            val indexRow = getRow(index)
            val indexCol = getCol(index)
            vector[indexRow] = vector[indexRow] and (1 shl indexCol).inv()
        }
    }

    // Инверсия бита
    fun inverseBit(index: Int) {
        if (index in 0 until vectorSize) {
            val indexRow = getRow(index)
            val indexCol = getCol(index)
            vector[indexRow] = vector[indexRow] xor (1 shl indexCol)
        }
    }

    override fun toString(): String = "BitVector ($vectorSize): ${getBitValues(intSize)}"

    private fun getBitValues(divider: Int, separator: String = "|"): String {
        val numBin = StringBuilder().append(separator)
        var c = 0
        for (i in 0 until vectorSize) {
            numBin.append(if (isSetBit(i)) '1' else '0').let { c++ }
            if (c == divider) numBin.append(separator).let { c = 0 }
            if (c != 0 && c % 8 == 0) numBin.append('.')
        }
        return numBin.toString()
    }
}

fun main() {
    val arr = intArrayOf(1, 3, 5, 6, 5, 8, 3, 31, 33, 64)
    val bitVector = CustomBitVector(64)

    for (i in arr.indices) {
        val iBit = arr[i] - 1
        if (bitVector.isSetBit(iBit)) {
            println("${arr[i]} is duplicate")
        } else {
            bitVector.setBit(iBit)
        }
    }
    println(bitVector)
}