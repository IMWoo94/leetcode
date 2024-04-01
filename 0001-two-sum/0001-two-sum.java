class Solution {
    public int[] twoSum(int[] nums, int target) {
		int[] answer;
		// key = number, value = index
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}

		// target 에서 현재 수를 뺀 값이 key 로 존재한다면 2 수의 합으로 target 성립
		for (int i = 0; i < nums.length; i++) {
			int key = target - nums[i];
			if (map.containsKey(key) && map.get(key) != i) {
				return new int[] {i, map.get(key)};
			}
		}

		return null;
    }
}