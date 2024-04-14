class Solution {
    public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> answer = new ArrayList<>();
		recursiveDFS(answer, new LinkedList<>(), n, 1, k);
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
}