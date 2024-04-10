class Solution {
    public int[] topKFrequent(int[] nums, int k) {
		// 엘리먼트의 빈도 수를 담을 Map
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		// 리스트의 엘리먼트 빈도 수 등록
		for (int num : nums) {
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
		}

		// 빈도 수를 기준으로 각 엘리먼트들을 담아둘 Map
		Map<Integer, List<Integer>> buckets = new HashMap<>();
		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);

			// 빈도 수에 해당하는 엘리먼트가 존재하지 않으면 빈 리스트 생성
			List<Integer> list = buckets.getOrDefault(frequency, new ArrayList<>());
			list.add(key);
			buckets.put(frequency, list);
		}

		// 결과로 리턴할 변수
		int[] result = new int[k];
		int index = 0;
		// 전체 엘리먼트 수를 통해서 빈도 찾기
		for (int i = nums.length; i >= 0 && index < k; i--) {
			// 해당 빈도에 값이 존재하면 엘리먼트를 결과 변수에 삽입
			if (buckets.get(i) != null) {
				// 해당 빈도에 엘리먼트 값이 여러개 등록되어 있을 수 있다.
				for (int elem : buckets.get(i)) {
					result[index] = elem;
					index++;
				}
			}
		}

		return result;
    }
}