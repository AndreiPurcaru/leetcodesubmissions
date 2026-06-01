package array

fun findErrorNums(nums: IntArray): IntArray {
    var occurences = IntArray(nums.size + 1)
    var doubled = 0
    var omitted = 0

    for (i in nums) {
        occurences[i]++
    }

    for (i in occurences.indices) {
        if (occurences[i] == 2) {
            doubled = i
        }
        if (occurences[i] == 0) {
            omitted = i
        }
    }

    return intArrayOf(doubled, omitted)
}

fun main() {
    println(findErrorNums(intArrayOf(1, 2, 2, 4)).toList())
}
