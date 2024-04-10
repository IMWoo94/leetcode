class Solution {
    public int[] topKFrequent(int[] nums, int k) {
		// 엘리먼트의 빈도 수를 담을 Map
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		// 리스트의 엘리먼트 빈도 수 등록
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// 빈도 순으로 우선순위 큐
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
		for (int elem : frequencyMap.keySet()) {
			pq.add(new int[] {elem, frequencyMap.get(elem)});
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = pq.poll()[0];
		}

		return result;
    }
}