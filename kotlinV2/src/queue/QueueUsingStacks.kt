package queue

class MyQueue() {
    private var s1 = ArrayDeque<Int>()
    private var s2 = ArrayDeque<Int>()
    private var front: Int = 0


    fun push(x: Int) {
        if (s1.isEmpty())
            front = x;
        s1.add(x);
    }

    fun pop(): Int {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.add(s1.removeLast());
        }
        return s2.removeLast();
    }

    fun peek(): Int {
        if (!s2.isEmpty()) {
            return s2.last();
        }
        return front;
    }

    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty();
    }

}