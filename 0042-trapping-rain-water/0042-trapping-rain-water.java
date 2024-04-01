class Solution {
    public int trap(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int leftMax = height[left];
		int rightMax = height[right];

		int volume = 0;

		// 두 포인터가 겹칠때 까지 진행
		while (left < right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);

			// 더 높은 쪽을 향해 작은 쪽이 포인터 이동
			if (leftMax <= rightMax) {
				// left 이동
				volume += leftMax - height[left];
				left++;
			} else {
				// right 이동
				volume += rightMax - height[right];
				right--;
			}
		}

		return volume;
    }
}