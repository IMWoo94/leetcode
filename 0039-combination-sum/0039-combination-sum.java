class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> elements = Arrays.stream(candidates).boxed().collect(Collectors.toList());
		recursiveDFS(results, elements, new ArrayDeque<>(), target, 0);
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
}