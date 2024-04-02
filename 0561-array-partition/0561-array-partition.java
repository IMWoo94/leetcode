class Solution {
    public int arrayPairSum(int[] nums) {
		// 오름 차순 정렬
		Arrays.sort(nums);

		int sum = 0;
		for (int i = 0; i < nums.length; i = i + 2) {
			// sum += Math.min(nums[i], nums[i + 1]);
            // 짝수 인덱스만 바라보아도 가능 단, 오름차순
            // 내림차순에서는 홀수 인덱스를 바라보아야한다.
            sum += nums[i];
		}

		return sum;
    }
}