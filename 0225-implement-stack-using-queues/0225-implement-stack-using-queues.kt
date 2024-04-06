class MyStack() {

    val queue = LinkedList<Int>()

    fun push(x: Int) {
        queue.push(x)

        for (i in 1 until queue.size) {
            queue.push(queue.remove())
        }
    }

    fun pop(): Int {
        return queue.remove()
    }

    fun top(): Int {
        return queue.peek()
    }

    fun empty(): Boolean {
        return queue.size == 0
    }

}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */