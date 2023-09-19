package calculations.recursion

/**
 * Палиндром (Palindrome).
 *
 * Число, буквосочетание, слово или текст, одинаково читающиеся в обоих направлениях.
 *
 * > saippuakivikauppias
 * > а роза упала на лапу Азора
 */

fun main() {
    val input = readln().also { print(it) }.replace("\\s".toRegex(), "").lowercase()
    println(" — is${if (isPalindrome(input, 0)) "" else " not"} a Palindrome.")
}

fun isPalindrome(str: String, i: Int): Boolean {
    val len = str.length
    if (i == len / 2) return true
    if (str[i] != str[len - 1 - i]) return false
    return isPalindrome(str, i + 1)
}