class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		recursiveDFS(results, list, 0, new ArrayDeque<>());
		return results;
    }
    
	public void recursiveDFS(List<List<Integer>> results, List<Integer> nums, int index, Deque<Integer> path) {
		results.add(new ArrayList<>(path));
		for (int i = index; i < nums.size(); i++) {
			path.add(nums.get(i));
			recursiveDFS(results, nums, i + 1, path);
			path.removeLast();
		}
	}
}