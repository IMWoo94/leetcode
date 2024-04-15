class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> elements = Arrays.stream(candidates).boxed().collect(Collectors.toList());
		// recursiveDFS(results, elements, new ArrayDeque<>(), target, 0);
        // iterativeDFS(results, elements, target);
        iterativeBFS(results, elements, target);
		return results;
    }
    
    public void recursiveDFS(List<List<Integer>> results, List<Integer> elements, Deque<Integer> comb, int target,
		int index) {
		if (target == 0) {
			results.add(comb.stream().collect(Collectors.toList()));
			return;
		}
		if (target < 0) {
			return;
		}

		for (int i = index; i < elements.size(); i++) {
			comb.add(elements.get(i));
			recursiveDFS(results, elements, comb, target - elements.get(i), i);
			comb.removeLast();
		}
	}
    
	public void iterativeDFS(List<List<Integer>> results, List<Integer> elements, int target) {
		Deque<combSum> stack = new ArrayDeque<>();
		stack.add(new combSum(new LinkedList<>(), 0, 0));

		while (!stack.isEmpty()) {
			combSum comb = stack.pop();

			if (comb.sum == target) {
				results.add(comb.list);
				continue;
			}
			if (comb.sum > target) {
				continue;
			}

			for (int i = comb.index; i < elements.size(); i++) {
				comb.list.add(elements.get(i));
				comb.sum += elements.get(i);
				stack.push(new combSum(new LinkedList<>(comb.list), i, comb.sum));
				comb.sum -= elements.get(i);
				comb.list.removeLast();
			}
		}

	}
    
	public void iterativeBFS(List<List<Integer>> results, List<Integer> elements, int target) {
		Queue<combSum> queue = new LinkedList<>();
		queue.add(new combSum(new LinkedList<>(), 0, 0));

		while (!queue.isEmpty()) {
			combSum comb = queue.poll();

			if (comb.sum == target) {
				results.add(comb.list);
				continue;
			}
			if (comb.sum > target) {
				continue;
			}

			for (int i = comb.index; i < elements.size(); i++) {
				comb.list.add(elements.get(i));
				comb.sum += elements.get(i);
				queue.add(new combSum(new LinkedList<>(comb.list), i, comb.sum));
				comb.sum -= elements.get(i);
				comb.list.removeLast();
			}
		}
	}

	class combSum {
		public LinkedList<Integer> list;
		public int index;
		public int sum;

		public combSum(LinkedList<Integer> list, int index, int sum) {
			this.list = list;
			this.index = index;
			this.sum = sum;
		}
	}
}