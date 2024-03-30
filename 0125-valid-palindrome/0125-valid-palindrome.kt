class Solution {
    fun isPalindrome(s: String): Boolean {
        var start = 0;
        var end = s.length - 1;

        while (start < end) {
            when {
                !Character.isLetterOrDigit(s[start]) -> start++
                !Character.isLetterOrDigit(s[end]) -> end--
                else -> {
                    if (s[start].lowercaseChar() != s[end].lowercaseChar()) {
                        println(s[start].lowercaseChar())
                        println(s[end].lowercaseChar())
                        return false
                    }
                    start++
                    end--
                }
            }
        }
        return true
    }
}