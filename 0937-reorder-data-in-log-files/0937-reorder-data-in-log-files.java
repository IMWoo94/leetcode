class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // 문자와 숫자의 정렬 방식이 다르므로, 둘을 분리하여 정렬하고 나중에 결과를 이어 붙이는 방식
		List<String> letterList = new ArrayList<>();
		List<String> digitList = new ArrayList<>();

		for (String log : logs) {
			char c = log.split(" ")[1].charAt(0);
			if (Character.isDigit(c))
				digitList.add(log);
			else
				letterList.add(log);
		}

		// 숫자 로그는 입력 순서대로니깐 완료

		// 문자 로그는 사전 순으로 하며, 동일한 경우 식별자로 따진다.
		letterList.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// 식별자, 전체 로그
				String[] idx1 = o1.split(" ", 2);
				String[] idx2 = o2.split(" ", 2);

				// 전체 로그가 동일한 경우 식별자 기준 정렬
				if (idx1[1].equals(idx2[1])) {
					return idx1[0].compareTo(idx2[0]);
				}
				return idx1[1].compareTo(idx2[1]);
			}
		});

		// 문자 로그 뒤 숫자 로그 붙이기
		letterList.addAll(digitList);

		return letterList.toArray(new String[0]);
    }
}