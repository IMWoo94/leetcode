class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
		List<String> answer = new LinkedList<>();
		Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();
		for (List<String> fromTo : tickets) {
			// key 와 해당하는 값이 없으면, new PriorityQueue() 생성 하고,
			// 일치하는 값이 있으면 현재값을 반환 합니다.
			fromToMap.putIfAbsent(fromTo.get(0), new PriorityQueue<>());
			fromToMap.get(fromTo.get(0)).add(fromTo.get(1));
		}
		// recursiveDFS(answer, fromToMap, "JFK");
        iterativeDFS(answer, fromToMap, "JFK");
		return answer;
	}
	
	// DFS - 재귀
	public void iterativeDFS(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {
		Deque<String> stack = new ArrayDeque<>();
		stack.push(from);

		while (!stack.isEmpty()) {
			while (fromToMap.containsKey(stack.getFirst()) && !fromToMap.get(stack.getFirst()).isEmpty()) {
				stack.push(fromToMap.get(stack.getFirst()).poll());
			}
			results.add(0, stack.pop());
		}

	}
}