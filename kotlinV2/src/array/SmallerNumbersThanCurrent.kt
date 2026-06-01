package array

fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    var frequency = IntArray(101)
    var smallerThanCurrent = IntArray(101)

    for (i in nums) {
        frequency[i]++
    }

    for (i in 1..<frequency.size) {
        smallerThanCurrent[i] = smallerThanCurrent[i - 1] + frequency[i - 1]
    }

    return nums.map {smallerThanCurrent[it]}.toIntArray()
}

fun main() {
    println(smallerNumbersThanCurrent(intArrayOf(8, 1, 2, 2, 3)).toList())
}
