class Solution {
    public int searchInsert(int[] nums, int target) {
        // 정렬된 배열이 주어지며, 배열의 원소 값은 중복되지 않은 정수로 이루어 집니다.
        // target 이 주어지면 target 과 일치하는 값이 있다면 해당 값의 index return
        // 일치하는 값이 없다면 target 이 들어갈만한 위치를 리턴
        
        // 모든 배열을 돌면서 정렬을 하는 케이스
//         int answer = nums.length;
//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] >= target){
//                 return i;
//             }
//         }
        
//         return answer;
        
        // 정렬된 배열이라면 이진탐색을 이용하여 시간복잡도를 줄일 수 있다. O(log n)
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
}