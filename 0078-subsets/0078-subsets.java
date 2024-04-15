class Solution {
    public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		// recursiveDFS(results, list, 0, new ArrayDeque<>());
        iterativeDFS(results, list);
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
    
	public void iterativeDFS(List<List<Integer>> results, List<Integer> nums) {
		Deque<Pair> stack = new ArrayDeque<>();

		stack.push(new Pair(0, new LinkedList<>()));

		while (!stack.isEmpty()) {

			Pair pair = stack.pop();

			results.add(new ArrayList<>(pair.path));

			for (int i = pair.index; i < nums.size(); i++) {
				pair.path.add(nums.get(i));
				stack.push(new Pair(i + 1, new LinkedList<>(pair.path)));
				pair.path.removeLast();
			}
		}
	}

	class Pair {
		public int index;
		public LinkedList<Integer> path;

		public Pair(int index, LinkedList<Integer> path) {
			this.index = index;
			this.path = path;
		}
	}
}