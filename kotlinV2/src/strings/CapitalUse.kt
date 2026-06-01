package strings

fun detectCapitalUse(word: String): Boolean {
    return word.lowercase() == word || word.uppercase() == word || (word[0].isUpperCase() && word.drop(1).all { it.isLowerCase() })
}

