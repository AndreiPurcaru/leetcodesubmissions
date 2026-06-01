package stack



enum class Status {
    START,
    END
}

data class Schedule(val id: Int, val status: Status, val timestamp: Int)

fun parse(s: String): Schedule {
    val split = s.split(":")

    return Schedule(split[0].toInt(), Status.valueOf(split[1].uppercase()), split[2].toInt())
}

fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    val accumulated = IntArray(n + 1)
    val stack = ArrayDeque<Schedule>()
    var currentTime = 0

    for (unparsed in logs) {
        val s = parse(unparsed)
        if (stack.isEmpty()) {
            stack.add(s)
            continue
        }

        val top = stack.last()


        when (s.status) {
            Status.START -> {
                accumulated[top.id] += s.timestamp - currentTime
                stack.add(s)
            }

            Status.END -> {
                accumulated[top.id] += s.timestamp - currentTime + 1
                stack.removeLast()
            }
        }
        currentTime = s.timestamp + (if (s.status == Status.END) 1 else 0)
    }

    return accumulated.take(n).toIntArray()
}


fun main() {
    println(exclusiveTime(2, listOf("0:start:0", "1:start:2", "1:end:5", "0:end:6")).contentToString())
}