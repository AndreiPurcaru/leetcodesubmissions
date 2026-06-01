package array

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    var frequency = IntArray(nums.size + 1)
    var result = mutableListOf<Int>()

    for (i in nums) {
        frequency[i]++
    }

    for (i in 1..<frequency.size) {
        if (frequency[i] == 0) {
            result.add(i)
        }
    }
    return result
}

fun main() {
    println(findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
}
