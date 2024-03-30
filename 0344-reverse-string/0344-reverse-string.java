class Solution {
    public void reverseString(char[] s) {
        int start = 0;
		int end = s.length - 1;

		while (start < end) {
			swap(start++, end--, s);
			// start++;
			// end--;
		}
    }
    
    public void swap(int a, int b, char[] s) {
		char temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}
}