class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
		int[] answer = new int[temperatures.length];

		// stack 선언
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < temperatures.length; i++) {
			// 현재 온도가 스택에 있는 온도보다 높다면 꺼내서 결과 업데이트
			while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
				int last = stack.pop();
				answer[last] = i - last;
			}

			stack.push(i);
		}

		return answer;
    }
}