class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 주어진 배열 안에서 두개의 값을 이용해서 target 의 값을 만들어내는 인덱스를 리턴
        int[] answer = new int[2];
        int size = nums.length;
        
        for(int i = 0; i < size - 1; i++){
            for(int j = i + 1; j < size; j++){
                int a = nums[i];
                int b = nums[j];
                int sum = a + b;
                if(sum == target){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }
}