package stack

fun evalRPN(tokens: Array<String>): Int {
    val stack = ArrayDeque<Int>()

    for (token in tokens) {
        when (token) {
            "+" -> stack.add(stack.removeLast() + stack.removeLast())
            "-" -> stack.add(-stack.removeLast() + stack.removeLast())
            "*" -> stack.add(stack.removeLast() * stack.removeLast())
            "/" -> {
                val divisor = stack.removeLast()
                stack.add(stack.removeLast() / divisor)
            }
            else -> stack.add(token.toInt())
        }
    }
    return stack.last()
}

fun main() {
    println(evalRPN(arrayOf("2", "1", "+", "3", "*")))
}
