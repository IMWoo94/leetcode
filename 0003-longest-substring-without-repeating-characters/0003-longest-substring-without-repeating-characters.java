class Solution {
    public int lengthOfLongestSubstring(String s) {
//         int n = s.length();
//         int maxLength = 0;
//         Set<Character> charSet = new HashSet<>();
//         int left = 0;
        
//         for (int right = 0; right < n; right++) {
//             if (!charSet.contains(s.charAt(right))) {
//                 charSet.add(s.charAt(right));
//                 maxLength = Math.max(maxLength, right - left + 1);
//             } else {
//                 while (charSet.contains(s.charAt(right))) {
//                     charSet.remove(s.charAt(left));
//                     left++;
//                 }
//                 charSet.add(s.charAt(right));
//             }
//         }
        
//         return maxLength;
        
//         int n = s.length();
//         int maxLength = 0;
//         Map<Character, Integer> charMap = new HashMap<>();
//         int left = 0;
        
//         for (int right = 0; right < n; right++) {
//             if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
//                 charMap.put(s.charAt(right), right);
//                 maxLength = Math.max(maxLength, right - left + 1);
//             } else {
//                 left = charMap.get(s.charAt(right)) + 1;
//                 charMap.put(s.charAt(right), right);
//             }
//         }
        
//         return maxLength;
        
        int prev = 0;
        int idx = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        
        while(idx < s.length()) {
            char curn = s.charAt(idx);
            if(!set.contains(curn)) {
                set.add(curn);
                idx++;
                max = Math.max(max, set.size());
            }
            else {
                set.remove(s.charAt(prev));
                prev++;
            }
        }
        return max;

    }
}