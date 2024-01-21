class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // num2 를 nums1 에 복사 -> 이때 nums1 의 시작 위치는 m 부터 이며, 복사 갯수는 n
        System.arraycopy( nums2, 0, nums1, m, n );
        
        Arrays.sort(nums1);
    }
}