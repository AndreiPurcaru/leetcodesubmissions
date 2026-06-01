package array

fun shuffle(nums: IntArray, n: Int): IntArray {
    var result = IntArray(n * 2)

    for (i in 0..<n) {
        result[2 * i] = nums[i]
        result[2 * i + 1] = nums[n + i]
    }

    return result
}

fun main() {
    println(shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3).toList())
}
