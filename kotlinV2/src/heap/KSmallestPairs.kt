package heap

import java.util.PriorityQueue

fun kSmallestPairsFail(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val heap1 = PriorityQueue(nums1.toList())
    val heap2 = PriorityQueue(nums2.toList())

//    return ( 0..< k).map { _ ->
//        val left = heap1.peek()
//        val right = heap2.peek()
//
//        if (left > right) {
//            heap1.remove()
//        } else if (left < right) {
//            heap2.remove()
//        } else {
//            if (heap1.size > 1 && heap2.size > 1) {
//                if (heap1.elementAt(1) > heap2.elementAt(1)) {
//                    heap2.remove()
//                } else {
//                    heap1.remove()
//                }
//            }
//        }
//
//        listOf(left, right)
//    }

    return ( 0..< k).map { _ ->
        val left = heap1.remove()
        val right = heap2.remove()

        var nextLeft: Int
        var nextRight: Int

        if (heap1.isNotEmpty() && heap2.isNotEmpty()) {
            nextLeft = heap1.peek()
            nextRight = heap2.peek()

            if (left + nextRight > right + nextLeft) {
                heap2.add(right)
            } else {
                heap1.add(left)
            }
        }

        if (heap1.isEmpty()) {
            heap1.add(left)
        }

        if (heap2.isEmpty()) {
            heap2.add(right)
        }

        listOf(left, right)
    }

}

fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val m = nums1.size
    val n = nums2.size

    val ans = mutableListOf<List<Int>>()
    val visited = mutableSetOf<Pair<Int, Int>>()

    val minHeap = PriorityQueue<IntArray>(compareBy { it[0] })
    minHeap.offer(intArrayOf(nums1[0] + nums2[0], 0, 0))
    visited.add(Pair(0, 0))

    var remaining = k
    while (remaining-- > 0 && minHeap.isNotEmpty()) {
        val (_, i, j) = minHeap.poll()

        ans.add(listOf(nums1[i], nums2[j]))

        if (i + 1 < m && Pair(i + 1, j) !in visited) {
            minHeap.offer(intArrayOf(nums1[i + 1] + nums2[j], i + 1, j))
            visited.add(Pair(i + 1, j))
        }

        if (j + 1 < n && Pair(i, j + 1) !in visited) {
            minHeap.offer(intArrayOf(nums1[i] + nums2[j + 1], i, j + 1))
            visited.add(Pair(i, j + 1))
        }
    }

    return ans
}

fun main() {
//    println(kSmallestPairs(intArrayOf(1,7,11), intArrayOf(2,4,6), 3))
//    println(kSmallestPairs(intArrayOf(1,1,2), intArrayOf(1,2,3), 2))
    println(kSmallestPairs(intArrayOf(1,2,4,5,6), intArrayOf(3,5,7,9), 3))
}