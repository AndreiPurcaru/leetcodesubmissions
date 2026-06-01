package stack.buildarray

// Efficient version
fun buildArray(target: IntArray, n: Int): List<String> {
    val PUSH = "Push"
    val POP = "Pop"
    val result = ArrayDeque<String>()
    var currentSeqNumber = 0

    for (currentIndex in target.indices) {
        while (currentSeqNumber < target[currentIndex] - 1) {
            result.add(PUSH)
            result.add(POP)
            currentSeqNumber++
        }
        if (currentSeqNumber < target[currentIndex]) {
            result.add(PUSH)
        }
        if (currentSeqNumber >= n) {
            break
        }
        currentSeqNumber++
    }
    return result
}

fun main() {
    println(buildArray(intArrayOf(1, 3), 3))
}
