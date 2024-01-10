class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 주어진 배열 안에서 두개의 값을 이용해서 target 의 값을 만들어내는 인덱스를 리턴
        int[] answer = new int[2];
        int size = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < size; i++){
            map.put(nums[i], i);
        }

        for(int i = 0; i < size; i++){
            int result = target - nums[i];
            if(map.containsKey(result) && map.get(result) != i){
                answer[0] = i;
                answer[1] = map.get(result);
                break;
            }
        }
        
        return answer;
    }
}