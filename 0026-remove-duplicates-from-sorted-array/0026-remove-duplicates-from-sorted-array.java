class Solution {
    public int removeDuplicates(int[] nums) {
        // 중복이 된다면 중복을 제거 하고, 모든 요소에 대해서 중복을 완료 한 경우 
        int k = 1;
        int size = nums.length;
        // 첫번째 요소는 무조건 고유한 요소임으로 패스
        for ( int i = 1; i < size; i++ ){
            if(nums[i] != nums[i-1]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}