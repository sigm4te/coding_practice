package custom

/**
 * Самодельный связанный список (Custom Linked List).
 */

class CustomLinkedList<T>(vararg values: T) {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    private data class Node<T>(var value: T, var next: Node<T>? = null)

    var size: Int = 0
        private set

    init {
        addAll(*values)
    }

    fun addAll(vararg values: T) {
        values.forEach { add(it) }
    }

    fun add(value: T, after: T? = null) {
        if (after == null) {
            addLast(value)
        } else {
            addValue(value, after)
        }
    }

    fun addFirst(value: T) {
        val node = Node<T>(value)
        if (head == null) {
            tail = node
        } else {
            node.next = head
        }
        head = node
        size++
    }

    fun addLast(value: T) {
        val node = Node<T>(value)
        if (tail == null) {
            head = node
        } else {
            tail!!.next = node
        }
        tail = node
        size++
    }

    private fun addValue(value: T, after: T) {
        val current = searchValue(after)
        if (current != null) {
            val node = Node(value)
            if (current == tail) {
                tail = node
            }
            node.next = current.next
            current.next = node
            size++
        }
    }

    private fun searchValue(value: T): Node<T>? {
        var current = head
        while (current != null) {
            if (current.value == value) return current
            current = current.next
        }
        return null
    }

    fun removeFirst() {
        if (head != null) {
            head = head?.next
            if (head == null) tail = null
            size--
        }
    }

    fun removeLast() {
        if (tail != null) {
            var prev = head
            var current = head
            while (current != null) {
                if (current == tail) {
                    if (current == head) {
                        head = null
                        tail = null
                        break
                    } else {
                        prev?.next = null
                        tail = prev
                    }
                }
                prev = current
                current = current.next
            }
            size--
        }
    }

    fun remove(value: T) {
        var prev = head
        var current = head
        while (current != null) {
            if (current.value == value) {
                if (current == head) {
                    head = current.next
                    if (prev == tail) tail = null
                } else {
                    prev?.next = current.next
                    if (current == tail) tail = prev
                }
                break
            }
            prev = current
            current = current.next
        }
        size--
    }

    fun clear() {
        while (size > 0) removeFirst()
    }

    override fun toString(): String {
        var current = head
        val result = StringBuilder()
        while (current != null) {
            result.append("[${current.value.toString()}] ")
            current = current.next
        }
        return "$size: $result"
    }
}

fun main() {
    val customList = CustomLinkedList<Int>(1, 9, 5)

    customList.addAll(2, 7, 5)
    println(customList)

    customList.add(3, 1)
    customList.removeFirst()
    println(customList)

    customList.clear()
    println(customList)
}