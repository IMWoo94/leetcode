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
		recursiveDFS(answer, fromToMap, "JFK");
		return answer;
	}
	
	// DFS - 재귀
	public void recursiveDFS(List<String> results, Map<String, PriorityQueue<String>> fromToMap, String from) {
		while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
			// 사전 어휘 순으로 첫 위치부터 우선순위 큐를 이용해 추출 및 재귀 DFS 진행
			recursiveDFS(results, fromToMap, fromToMap.get(from).poll());
		}
		// 재귀가 끝나면, 더 이상 이동할 수 있는 여행지가 없다는 뜻이며, 최종 도착지가 됩니다.
		// 돌아가면 각각의 위치를 맨앞으로 넣는다면 여행경로가 완성이 된다.
		results.add(0, from);
	}
}