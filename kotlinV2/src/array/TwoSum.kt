package array

import jdk.internal.org.commonmark.text.Characters.skip

fun twoSumMeh(nums: IntArray, target: Int): IntArray {
    val numsSet = nums.toSet()

    for (index in nums.indices) {
        val currentValue = nums[index]
        val pairValue = target - currentValue

        if (numsSet.contains(pairValue)) {
            val pairIndex = findIndexSkipping(nums, pairValue, index)
            if (pairIndex == -1) {
                continue
            }
            return intArrayOf(index, pairIndex)
        }
    }

    return intArrayOf()
}

fun findIndexSkipping(nums: IntArray, value: Int, skipIndex: Int): Int {
    for (index in nums.indices.reversed()) {
        if (nums[index] == value && index != skipIndex) return index
    }

    return -1
}


fun twoSum(nums: IntArray, target: Int): IntArray {
    val numsSet = mutableSetOf<Int>()

    for ((indexRight, value) in nums.withIndex()) {
        val valueNeededToTarget = target - value

        if (numsSet.contains(valueNeededToTarget)) {
            val indexLeft = findIndex(nums, valueNeededToTarget)

            return intArrayOf(indexLeft, indexRight)
        }
        numsSet.add(value)
    }
    return intArrayOf()
}

fun findIndex(nums: IntArray, value: Int): Int {
    for (index in nums.indices) {
        if (nums[index] == value) return index
    }

    return -1
}

fun main() {

}