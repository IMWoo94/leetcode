class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val word: MutableMap<Char, Int> = mutableMapOf()
        var max = 0
        var left = 0
        var right = 0

        for (c in s.toCharArray()) {
            if (word.containsKey(c) && left <= word.getOrDefault(c, -1)) {
                left = word[c]!! + 1
            } else {
                max = max(max, right - left + 1)
            }

            word[c] = right
            right++
        }

        return max
    }
}