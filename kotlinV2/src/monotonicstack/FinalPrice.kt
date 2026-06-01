package monotonicstack

fun finalPrices(prices: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    val result = prices.copyOf()

    for ((index, price) in prices.withIndex()) {

        while (stack.isNotEmpty() && prices[stack.last()] >= price) {
            result[stack.removeLast()] -= price
        }
        stack.add(index)
    }
    return result

}

fun main() {
    println(finalPrices(intArrayOf(8,4,6,2,3)).contentToString())
}