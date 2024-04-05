class Solution {
    public String removeDuplicateLetters(String s) {
		// 문자의 갯수를 계산해서 담아둘 변수
		Map<Character, Integer> counter = new HashMap<>();
		// 처리 여부
		Map<Character, Boolean> seen = new HashMap<>();
		// 문제 풀이에 사용할 스택
		Deque<Character> stack = new ArrayDeque<>();

		// 문자 갯수 카운팅
		for (char c : s.toCharArray()) {
			counter.put(c, counter.getOrDefault(c, 0) + 1);
		}

		for (char c : s.toCharArray()) {
			// 현재 처리하는 문자는 카운터에서 -1 처리
			counter.put(c, counter.get(c) - 1);

			// 이미 처리한 문자는 패스
			if (seen.containsKey(c) && seen.get(c) == true)
				continue;

			// 스택에 존재하는 문자가 현재 문자보다 더 뒤에 붙어야 할 문자라면 스택에서 제거
			// 처리하지 않는 것으로 표시
			while (!stack.isEmpty() && stack.peek() > c && counter.get(stack.peek()) > 0) {
				seen.put(stack.pop(), false);
			}

			// 현재 문자를 스택에 삽입
			stack.push(c);

			// 현재 문자 처리 표시
			seen.put(c, true);
		}

		// 스택에 존재하는 문자를 큐 순서대로 추출
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		return sb.toString();
	}
}