class Solution {
    int left, maxLen;
    
    public String longestPalindrome(String s) {
		int len = s.length();
		// 한자리 단어라면 팰린드롬 무조건 성립 및 가장 긴 케이스
		if (len < 2)
			return s;

		for (int i = 0; i < len - 1; i++) {
			// 짝수 팰린드롬 확인
			extendPalindrome(s, i, i + 1);
			// 홀수 팰린드롬 확인
			extendPalindrome(s, i, i + 2);
		}

		return s.substring(left, left + maxLen);

	}

	public void extendPalindrome(String s, int start, int end) {
		// 투 포인터에 대해서 유효한 범위 인지,
		// 양쪽 끝 문자가 일치하는 경우에 팰린드롬 범위를 앞뒤로 한칸씩 확장
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}

		if (maxLen < end - start - 1) {
			left = start + 1;
			maxLen = end - start - 1;
		}
	}
}