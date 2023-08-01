package custom

/**
 * Самодельное множество <целых чисел> (Custom Set <Ints>).
 */

class CustomSet(private val size: Int) {
    private var value: ArrayList<ArrayList<Int>> = arrayListOf()

    init {
        for (i in 0 until size) {
            value.add(arrayListOf())
        }
    }

    fun find(x: Int): Boolean {
        value[x % size].forEach {
            if (it == x) return true
        }
        return false
    }

    fun add(x: Int) {
        if (!find(x)) {
            value[x % size].add(x)
        }
    }

    fun addAll(vararg xs: Int) {
        xs.forEach {
            add(it)
        }
    }

    fun delete(x: Int) {
        if (find(x)) {
            val set = value[x % size]
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
    val customSet = CustomSet(10).apply { addAll(1, 3, 7, 9, 11, 12, 15, 18, 22, 25, 28) }

    customSet.add(10)
    println(customSet.toString())

    customSet.delete(22)
    println(customSet.toString())
}