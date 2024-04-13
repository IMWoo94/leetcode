import java.util.*;

class Solution {
    Map<Character, List<Character>> phoneWords = new HashMap<>() {{
		put('2', Arrays.asList('a', 'b', 'c'));
		put('3', Arrays.asList('d', 'e', 'f'));
		put('4', Arrays.asList('g', 'h', 'i'));
		put('5', Arrays.asList('j', 'k', 'l'));
		put('6', Arrays.asList('m', 'n', 'o'));
		put('7', Arrays.asList('p', 'q', 'r', 's'));
		put('8', Arrays.asList('t', 'u', 'v'));
		put('9', Arrays.asList('w', 'x', 'y', 'z'));
	}};
    
    public List<String> letterCombinations(String digits) {

		List<String> answer = new ArrayList<>();
		if (digits.isEmpty()) {
			return answer;
		}
		dfs(answer, digits, 0, new StringBuilder());

		return answer;
    }
    
    public void dfs(List<String> result, String digits, int index, StringBuilder path) {
		// 만들어진 문자열에 대해서 digits 길이와 동일하다면 return
		if (digits.length() == path.length()) {
			result.add(path.toString());
			return;
		}

		// 주어진 문자열의 위치에 따른 조합 가능한 단어 목록별로 반복
		for (char c : phoneWords.get(digits.charAt(index))) {
			dfs(result, digits, index + 1, new StringBuilder(path).append(c));
		}
	}
}