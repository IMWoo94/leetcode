import java.util.ArrayDeque

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)

        // stack 선언
        val stack: Deque<Int> = ArrayDeque()

        for (i in 0 until temperatures.size) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                var lastIndex = stack.pop()
                result[lastIndex] = i - lastIndex
            }

            stack.push(i)
        }
        return result
    }
}