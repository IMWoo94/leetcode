class Solution {
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> answer = new ArrayList<>();
		// recursiveDFS(answer, new LinkedList<>(), n, 1, k);
        iterativeDFS(answer, n, k);
        return answer;
    }
    
	public void recursiveDFS(List<List<Integer>> results, LinkedList<Integer> elements, int n, int start, int k) {
		// k 번째 노드에 도달하면 결과에 추가
		if (k == 0) {
			results.add(elements.stream().collect(Collectors.toList()));
			return;
		}

		for (int i = start; i <= n; i++) {
			// 전달 받은 엘리먼트 더해 현재 엘리먼트 추가
			elements.add(i);
			recursiveDFS(results, elements, n, i + 1, k - 1);
			// 돌아온 후 현재 엘리먼트 제거
			elements.removeLast();
		}
	}
    
	public void iterativeDFS(List<List<Integer>> results, int n, int k) {
		Deque<LinkedList<Integer>> stack = new ArrayDeque<>();

        stack.add(new LinkedList<>());
		while (!stack.isEmpty()) {
			LinkedList<Integer> current = stack.pop();

			if (current.size() == k) {
				results.add(current);
				continue;
			}

			int start = current.isEmpty() ? 1 : current.get(current.size() - 1) + 1;
			for (int i = start; i <= n; i++) {
				current.add(i);
				stack.add(new LinkedList<>(current));
				current.removeLast();
			}
		}
	}
}