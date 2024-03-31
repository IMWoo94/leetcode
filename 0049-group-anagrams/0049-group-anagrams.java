class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> result = new HashMap<>();

		for (String s : strs) {
			char[] charArray = s.toCharArray();
			// 단어 사전순 정렬
			Arrays.sort(charArray);

			String key = String.valueOf(charArray);
			// list 초기화
			if (!result.containsKey(key)) {
				result.put(key, new ArrayList<>());
			}
			result.get(key).add(s);
		}

		return new ArrayList<>(result.values());
    }
}