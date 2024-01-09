class Solution {
    public boolean isPalindrome(int x) {
        String origin = String.valueOf(x);
        
        StringBuilder sb = new StringBuilder(origin);
        sb.reverse();
        
        boolean answer = origin.equals(sb.toString());
        
        return answer;
    }
}