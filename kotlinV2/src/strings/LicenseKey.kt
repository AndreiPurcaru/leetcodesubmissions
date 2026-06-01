package strings

fun licenseKeyFormatting(s: String, k: Int): String {
    return s.split("-").joinToString("").reversed().chunked(k).joinToString("-").reversed().uppercase()
}