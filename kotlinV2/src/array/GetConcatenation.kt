package array

fun getConcatenation(nums: IntArray): IntArray {
    var n = nums.size
    var result = IntArray(n * 2)

    for (i in 0..<nums.size) {
        result[i] = nums[i]
        result[n + i] = nums[i]
    }
    return result
}

fun main() {
    println(getConcatenation(intArrayOf(1, 2, 1)).toList())
}
