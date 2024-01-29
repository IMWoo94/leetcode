class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        
        for(int i = 0; i < numRows; i++){
            List<Integer> row = new ArrayList<>();
            if(i == 0){
                answer.add(new ArrayList<>(Arrays.asList(1)));
                continue;
            }else if(i == 1){
                answer.add(new ArrayList<>(Arrays.asList(1,1)));
                continue;
            }else{
                for(int k = 0; k <= i; k++){
                    if(k == 0 || k == i){
                        row.add(1);
                    }else{
                        int sum = answer.get(i-1).get(k-1) + answer.get(i-1).get(k);
                        row.add(sum);
                    }
                }
                answer.add(row);
            }
        }
        
        return answer;
    }
}