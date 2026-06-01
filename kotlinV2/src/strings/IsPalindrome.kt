package strings

fun isPalindrome(s: String): Boolean {
    val cleanedInput = s.filter { it.isLetterOrDigit() }.lowercase()


    var left = 0
    var right = cleanedInput.length - 1

    while (left < right) {
        if (cleanedInput[left] != cleanedInput[right]) {
            return false
        }
        left++
        right--
    }
    return true
}

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama"))
    println(isPalindrome("race a car"))
}