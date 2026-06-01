enum class StackOperation {
    PUSH, POP;

    override fun toString(): String {
        return name.lowercase().replaceFirstChar { it.uppercase() }
    }
}
// Fun version with sequence
fun buildArrayWithSequence(target: IntArray, n: Int): List<String> {


    val seq = generateSequence(0) {it + 1}.iterator()
    val result = ArrayDeque<StackOperation>()

    for (currentIndex in target.indices) {
        var currentSeqNumber = seq.next()
        while (currentSeqNumber < target[currentIndex] - 1) {
            result.add(StackOperation.PUSH)
            result.add(StackOperation.POP)
            currentSeqNumber = seq.next()
        }
        if (currentSeqNumber < target[currentIndex]) {
            result.add(StackOperation.PUSH)
        }
        if (currentSeqNumber >= n) {
            break
        }
    }
    return result.toList().map {it.toString()}
}

fun main() {
    println(buildArrayWithSequence(intArrayOf(1, 3), 3))
}
