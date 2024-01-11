class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        Arrays.sort(strs);
        String start = strs[0];
        String end = strs[strs.length-1];
        int size = Math.min(start.length(), end.length());
        for ( int i =0 ; i < size; i++){
            if(start.charAt(i) != end.charAt(i)){
                return answer;
            }
            answer += start.charAt(i);
        }
        
        return answer;
    }
}