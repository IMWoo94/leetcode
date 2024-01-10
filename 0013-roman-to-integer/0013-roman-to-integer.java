class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        Map<String, Integer> nums = new HashMap<>(){{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};
        
        List<Integer> list = new ArrayList<>();
        
        String[] str = s.split("");
        for(String num : str){
            list.add(nums.get(num));
        }
        
        int size = list.size();
        if(size == 1){
            answer += list.get(size-1);
        }else{
            for(int i = 0; i < size-1; i++){
                if(list.get(i) < list.get(i+1)){
                    // 2자리로 뺴야하는 수
                    answer += list.get(i+1) - list.get(i);
                    i++;
                }else{
                    // 하나의 값으로 계산
                    answer += list.get(i);
                }
                
                if( i == size -2 ){
                    answer += list.get(size-1);
                }
        
            }
        }
        
        
        return answer;
    }
}