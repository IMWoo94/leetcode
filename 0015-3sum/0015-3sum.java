class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
		int left, right, sum = 0;
		List<List<Integer>> answer = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			left = i + 1;
			right = nums.length - 1;
			while (left < right) {
				sum = nums[i] + nums[left] + nums[right];
				// 0 보다 작으면 left 이동하여 더 큰수 사용
				if (sum < 0) {
					left++;
				} else if (sum > 0) {
					right--;
				} else {
					// 0 인 경우
					answer.add(List.of(nums[i], nums[left], nums[right]));

					// left, right 의 중복값 건너뛰기
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}

					// 정답이 나왔으므로 다음 left, right 사용
					left++;
					right--;
				}
			}

		}

		return answer;
    }
}