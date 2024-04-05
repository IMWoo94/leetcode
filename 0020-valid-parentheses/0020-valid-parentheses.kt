import java.util.ArrayDeque

class Solution {
    fun isValid(s: String): Boolean {
        var map: Map<Char,Char> = mutableMapOf(
            ')' to '(',
            '}' to '{',
            ']' to '['
        )

        val stack: Deque<Char> = ArrayDeque()

        for (i in s.indices) {
            if (!map.containsKey(s[i])) {
                stack.push(s[i])
            } else if (stack.isEmpty() || map[s[i]] != stack.pop()) {
                return false
            }
        }

        return stack.isEmpty()
    }
}