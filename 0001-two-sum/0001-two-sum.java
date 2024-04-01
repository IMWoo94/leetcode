class Solution {
    public int[] twoSum(int[] nums, int target) {
		int[] answer;
		// key = number, value = index
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			// target 에서 num 을 뺸 값이 존재하면 정답으로 리턴
			if (map.containsKey(target - nums[i])) {
				return new int[] {map.get(target - nums[i]), i};
			}

			// 정답이 아니므로 현재 인덱스 저장
			map.put(nums[i], i);
		}

		return null;
    }
}