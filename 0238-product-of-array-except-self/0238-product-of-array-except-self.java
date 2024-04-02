class Solution {
    public int[] productExceptSelf(int[] nums) {
		int[] answer = new int[nums.length];

		// 왼쪽 값 곱하기
		int p = 1;
		for (int i = 0; i < nums.length; i++) {
			answer[i] = p;
			p *= nums[i];
		}

		// 오른쪽 값 곱하기 왼쪽 값과 차례로 곱하기
		p = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			answer[i] *= p;
			p *= nums[i];
		}

		return answer;
    }
}