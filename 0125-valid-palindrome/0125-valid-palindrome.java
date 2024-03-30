class Solution {
    public boolean isPalindrome(String s) {
        // 처음 끝 단어에 대해서 영숫자라면 서로의 일치하는지 확인하는 방법
		int start = 0;
		int end = s.length() - 1;
		// 서로 중앙으로 이동하면서 나가다 겹치는 지점에 도달하면 종료
		while (start < end) {
			// 영숫자 판별
			if (!Character.isLetterOrDigit(s.charAt(start))) {
				start++;
			} else if (!Character.isLetterOrDigit(s.charAt(end))) {
				end--;
			} else {
				// 둘다 유효한 문자인 경우 소문자로 변경 비교
				if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
					return false;
				}

				start++;
				end--;
			}
		}
		return true;
    }
}