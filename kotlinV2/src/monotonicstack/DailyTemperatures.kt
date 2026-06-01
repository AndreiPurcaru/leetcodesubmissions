package monotonicstack

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val result = IntArray(temperatures.size)

    for ((index, temperature) in temperatures.withIndex()) {

        while (stack.isNotEmpty() && temperatures[stack.last()] < temperature) {
            val lastIndex = stack.removeLast()
            result[lastIndex] = index - lastIndex
        }
        stack.add(index)
    }
    return result
}

fun main() {
    println(dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)).contentToString())
}