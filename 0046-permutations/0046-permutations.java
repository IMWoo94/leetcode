class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
		List<Integer> list = Arrays.stream(nums).boxed().toList();
		// dfs(answer, new ArrayList<>(), list);
        iterativeDFS(answer, list);
		return answer;
    }
    
    public void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
		// 리프 노드에 도달하면 결과 추가
		// 즉, 더 이상 조합할 요소가 없는 경우, 원하는 케이스로 조합이 완료
		if (elements.isEmpty()) {
			results.add(prevElements.stream().toList());
		}

		// 전달받은 모든 엘리먼트를 탐색
		for (Integer e : elements) {
			// 전달받은 요소에 대해서 현재 요소를 제거하고 새롭게 구성.
			// 이는 다음 요소를 등록하는데 있어서 가용 가능한 요소 리스트
			List<Integer> nextElements = new ArrayList<>(elements);
			nextElements.remove(e);

			// 기존의 값에 현재 요소 추가
			// 해당 엘리먼트가 조합이 만들어지는 리스트
			prevElements.add(e);
			dfs(results, prevElements, nextElements);
			// 재귀를 나오게 되면 현재 요소에 대해서 제외
			prevElements.remove(e);
		}
	}
    
	public void iterativeDFS(List<List<Integer>> results, List<Integer> elements) {
		Deque<List<Integer>> stack = new ArrayDeque<>();

		for (int e : elements) {
			stack.push(Arrays.asList(e));

			while (!stack.isEmpty()) {
				List<Integer> permute = stack.pop();
				if (permute.size() == elements.size()) {
					results.add(permute);
					continue;
				}

				for (int num : elements) {
					if (!permute.contains(num)) {
						List<Integer> temp = new ArrayList<>(permute);
						temp.add(num);
						stack.push(temp);
					}
				}
			}
		}
	}
}