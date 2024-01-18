class Solution {
    public int removeElement(int[] nums, int val) {
//         int index = 0;
        
//         for(int num : nums){
//             if(num != val){
//                 nums[index++] = num;
//             }
//         }
//         return index;
        int originSize = nums.length;
        int answer = nums.length;
        
        for( int i = 0; i < answer; i++ ){
            // 주어진 값과 배열의 값이 같은 경우
            if( nums[i] == val ){
                // 현재 위치의 값을 이후의 값으로 앞으로 땡겨서 가져온다.
                for( int k = i + 1; k < originSize; k++){
                    nums[k-1] = nums[k];
                }
                answer--;
                i--;
            }
        }
        return answer;
    }
}