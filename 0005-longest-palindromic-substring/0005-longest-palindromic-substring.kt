class Solution {
    var left: Int = 0
    var maxLen: Int = 0
    fun longestPalindrome(s: String): String {
        // 문자 길이 저장
        val len = s.length

        // 길이가 1인 경우 예외 처리
        if (len < 2) return s

        // 우측으로 한칸씩 이동하면 투 포인터 조사
        for (i in 0 until len - 1) {
            extendPalindrome(s, i, i + 1)
            extendPalindrome(s, i, i + 2)

        }

        return s.substring(left, left + maxLen)
    }

    fun extendPalindrome(s: String, start: Int, end: Int) {
        // 파라미터 수정 불가 별도 var 선언
        var l = start
        var r = end

        // 투 포인터가 유효한 범위 내 있고 양쪽 끝 문자가 팰린드롬인 경우
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--
            r++
        }

        if (maxLen < r - l - 1) {
            left = l + 1
            maxLen = r - l - 1
        }
    }
}