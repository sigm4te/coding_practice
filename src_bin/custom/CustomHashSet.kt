package custom

/**
 * Самодельное хэш-множество <целых чисел> (Custom Hash Set <Ints>).
 */

class CustomHashSet(private val size: Int) {
    private var value: ArrayList<ArrayList<Int>> = arrayListOf()

    init {
        for (i in 0 until size) {
            value.add(arrayListOf())
        }
    }

    private fun hash(x: Int): Int = x % size

    fun find(x: Int): Boolean {
        value[hash(x)].forEach {
            if (it == x) return true
        }
        return false
    }

    fun add(x: Int) {
        if (!find(x)) {
            value[hash(x)].add(x)
        }
    }

    fun addAll(vararg xs: Int) {
        xs.forEach {
            add(it)
        }
    }

    fun delete(x: Int) {
        if (find(x)) {
            val set = value[hash(x)]
            for (i in 0 until set.size) {
                if (set[i] == x) {
                    set[i] = set.last()
                    set.removeLast()
                }
            }
        }
    }

    override fun toString(): String = value.joinToString(" ")
}

fun main() {
    val customSet = CustomHashSet(10).apply { addAll(1, 3, 7, 9, 11, 12, 15, 18, 22, 25, 28) }

    customSet.add(10)
    println(customSet.toString())

    customSet.delete(22)
    println(customSet.toString())
}