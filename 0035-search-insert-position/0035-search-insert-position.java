class Solution {
    public int searchInsert(int[] nums, int target) {
        int answer = -1;
        // 정렬된 배열이 주어지며, 배열의 원소 값은 중복되지 않은 정수로 이루어 집니다.
        // target 이 주어지면 target 과 일치하는 값이 있다면 해당 값의 index return
        // 일치하는 값이 없다면 target 이 들어갈만한 위치를 리턴
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        
        // 일치하지 않는 경우 들어갈 위치를 찾아야 한다.
        if(nums[0] > target){
            return 0;
        }else if(nums[nums.length - 1] < target){
            return nums.length;
        }else{
            for(int i = 0; i < nums.length -1; i++){
                if(nums[i] < target && nums[i + 1] > target){
                    return i+1;
                }
            }
        }
        
        return answer;
    }
}