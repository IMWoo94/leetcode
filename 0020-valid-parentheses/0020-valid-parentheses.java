class Solution {
    public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>() {{
			put(')', '(');
			put('}', '{');
			put(']', '[');
		}};

		// stack 생성
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			// 열림 괄호 인 경우 stack push
			if (!map.containsKey(c)) {
				stack.push(c);
			}
			// 닫힘 괄호에서 stack 이 비어있거나, 스택에 있는 열림 괄호와 다른 경우 false
			else if (stack.isEmpty() || stack.pop() != map.get(c)) {
				return false;
			}
		}

		// 유효하기 위해선 stack 이 비어 있어야 한다.
		return stack.isEmpty();
    }
}