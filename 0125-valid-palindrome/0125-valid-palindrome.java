class Solution {
    public boolean isPalindrome(String s) {
        // 소문자 처리
		String lowerString = s.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for(char c : lowerString.toCharArray()){
			// 영숫자 확인
			if(Character.isLetterOrDigit(c)) sb.append(c);
		}

		String a = sb.toString();
		String b = sb.reverse().toString();

		return a.equals(b);
    }
}