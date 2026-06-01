package array

fun findMaxConsecutiveOnes(nums: IntArray): Int {
    var maxConsecutive = 0
    var currentConsecutive = 0

    for (i in nums) {
        if (i == 1) {
            currentConsecutive++
            if (currentConsecutive > maxConsecutive) {
                maxConsecutive = currentConsecutive
            }
        } else {
            currentConsecutive = 0
        }
    }
    return maxConsecutive
}

fun main() {
    println(findMaxConsecutiveOnes(intArrayOf(1, 1, 0, 1, 1, 1)))
}
