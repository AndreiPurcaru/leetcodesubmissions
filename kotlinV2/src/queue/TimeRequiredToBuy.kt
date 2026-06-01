package queue

fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
    val maxRepetitions = tickets[k]

    return tickets.foldIndexed(0) { index, acc, ticket  ->
        val bound = minOf(ticket, maxRepetitions)
        // For all the purchases after our index, if they need to wait more
        // or equal to us, we gain 1s for each since we are before them to being with
        val adjusted = bound + (if (index > k && maxRepetitions <= ticket) -1 else 0)
        acc + adjusted
    }
}

fun main() {
    println(timeRequiredToBuy(intArrayOf(2,3,2), 2))
    println(timeRequiredToBuy(intArrayOf(5,1,1,1), 0))
    println(timeRequiredToBuy(intArrayOf(84,49,5,24,70,77,87,8), 3))
}