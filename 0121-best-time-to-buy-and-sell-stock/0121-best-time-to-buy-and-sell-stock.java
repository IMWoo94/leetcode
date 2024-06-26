class Solution {
    public int maxProfit(int[] prices) {
		int max = 0;

		// 저점은 임시로 맨 첫 원소 값
		int min = prices[0];

		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]);

			max = Math.max(max, prices[i] - min);
		}

		return max;
    }
}