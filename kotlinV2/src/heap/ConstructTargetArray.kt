package heap

import java.util.*


data class TargetToIndex(val target: Int, val index: Int)

fun isPossibleBorked(target: IntArray): Boolean {

    val heap = PriorityQueue<TargetToIndex>(target.size, compareBy { it.target })
    val result = IntArray(target.size) {1}
    var sum = target.size

    target.mapIndexedTo(heap) { index, el -> TargetToIndex(el, index) }

    while(heap.isNotEmpty()) {
        val currentTarget = heap.remove()

        while (result[currentTarget.index] < currentTarget.target) {
            val previousValue = result[currentTarget.index]
            result[currentTarget.index] = sum
            sum = sum - previousValue + result[currentTarget.index]
        }

        if (result[currentTarget.index] != currentTarget.target) {
            return false
        }
    }

    return true
}

fun isPossible(target: IntArray): Boolean {
    if (target.size == 1) return target[0] == 1

    val pq = PriorityQueue<Int>(reverseOrder())
    var sum = 0L
    for (t in target) {
        pq.add(t)
        sum += t
    }

    while (pq.peek() != 1) {
        val curr: Int = pq.poll()!!
        if (sum - curr == 1L) return true

        val x = curr % (sum - curr)
        sum = sum - curr + x

        if (x == 0L || x == curr.toLong()) return false
        else pq.add(x.toInt())
    }

    return true
}

fun main() {
//    println(isPossible(intArrayOf(9,3,5)))
//    println(isPossible(intArrayOf(1,1,1,2)))
    println(isPossible(intArrayOf(8,5)))
}