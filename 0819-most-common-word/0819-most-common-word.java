class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
		// 정규식을 이용해서 문자 이외 단어 제거
		// 소문자 처리
		// 단어 기반으로 분리
		String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");

		// 개수 처리 및 추출
		Map<String, Integer> counts = new HashMap<>();
		// 금지 목록
		Set<String> ban = new HashSet<>(Arrays.asList(banned));

		for (String word : words) {
			// 금지 단어가 아닌 경우에만
			if (!ban.contains(word)) {
				counts.put(word, counts.getOrDefault(word, 0) + 1);
			}
		}

		return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
	}
}