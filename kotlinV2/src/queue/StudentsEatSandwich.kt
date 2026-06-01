package queue

fun countStudents(students: IntArray, sandwiches: IntArray): Int {

    var currentSandwichIndex = 0
    val studentsQueue = ArrayDeque(students.toList())
    var queuedSinceLastAte = 0

    while (currentSandwichIndex < sandwiches.size && queuedSinceLastAte < studentsQueue.size) {
        if (studentsQueue.first() == sandwiches[currentSandwichIndex]) {
            studentsQueue.removeFirst()
            currentSandwichIndex++
            queuedSinceLastAte = 0
        } else {
            studentsQueue.add(studentsQueue.removeFirst())
            queuedSinceLastAte++
        }
    }

    return studentsQueue.size
}

fun main() {
    println(countStudents(intArrayOf(1,1,1,0,0,1), intArrayOf(1,0,0,0,1,1)))
    println(countStudents(intArrayOf(1,1,0,0), intArrayOf(0,1,0,1)))
}