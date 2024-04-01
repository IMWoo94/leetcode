class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 답은 2개의 숫자를 합하여 리턴하는 것으로 배열의 크기는 2로 고정
		int[] answer = new int[2];

		int len = nums.length;
		// 하나씩 하나씩 모든 경우의 수를 비교해보면서 target 과 일치하는 값 찾기
		for (int a = 0; a < len; a++) {
			for (int b = a + 1; b < len; b++) {
				if (nums[a] + nums[b] == target) {
					answer[0] = a;
					answer[1] = b;
				}
			}
		}
		return answer;
    }
}