package heap

import java.util.PriorityQueue

fun lastStoneWeight(stones: IntArray): Int {
    val heap = PriorityQueue<Int>(stones.size, reverseOrder())

    heap.addAll(stones.toList())

    while (heap.size > 1) {
        val smashingResult = heap.remove() - heap.remove()
        if (smashingResult > 0) {
            heap.add(smashingResult)
        }
    }

    return if (heap.isNotEmpty()) heap.peek() else 0
}

fun main() {
    println(lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
}