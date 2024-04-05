class Solution {
    public String removeDuplicateLetters(String s) {
		// 정렬된 문자열 집합 순회
		for (char c : toSortedSet(s)) {
			// 해당 문자가 포함된 위치부터 접미사로 지정
			String suffix = s.substring(s.indexOf(c));
			// 전체 집합과 접미사 집합이 일치하면 해당 문자 정답에 추가하고 재귀 호출 진행
			if (toSortedSet(s).equals(toSortedSet(suffix))) {
				return c + removeDuplicateLetters(suffix.replace(String.valueOf(c), ""));
			}
		}

		return "";
    }
    
    private Set<Character> toSortedSet(String s) {
		// 문자열을 문자 단위 집합으로 저장할 변수 선언
		Set<Character> set = new TreeSet<>(new Comparator<Character>() {
			@Override
			public int compare(Character o1, Character o2) {
				if (o1 == o2) {
					return 0;
				} else if (o1 > o2) {
					return 1;
				} else {
					return -1;
				}
			}
		});

		// 문자열을 문자 단위로 집합에 저장, 정렬된 상태로 저장된다. 저장 순서는 사전순
		for (int i = 0; i < s.length(); i++) {
			set.add(s.charAt(i));
		}

		return set;
	}
}