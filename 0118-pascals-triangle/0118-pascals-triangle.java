class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        
        // 초기 데이터 생성 처음과 마지막 인덱스 1로 채우기
        for(int i = 0; i < numRows; i++){
            // 각각의 층마다 생성되여아 하는 배열 갯수 생성
            Integer[] row = new Integer[i+1];
            // 생선된 배열의 모든 원소를 1 로 채움
            Arrays.fill(row, 1);
            answer.add(Arrays.asList(row));
        }
        
        for(int i = 2; i < numRows; i++){
            for(int k = 1; k < i; k++){
                List<Integer> row = answer.get(i);
                List<Integer> ref = answer.get(i - 1);
                int sum = ref.get(k-1) + ref.get(k);
                row.set(k, sum);
            }
        }
        
        // for(int i = 0; i < numRows; i++){
        //     List<Integer> row = new ArrayList<>();
        //     if(i == 0){
        //         answer.add(new ArrayList<>(Arrays.asList(1)));
        //         continue;
        //     }else if(i == 1){
        //         answer.add(new ArrayList<>(Arrays.asList(1,1)));
        //         continue;
        //     }else{
        //         for(int k = 0; k <= i; k++){
        //             if(k == 0 || k == i){
        //                 row.add(1);
        //             }else{
        //                 int sum = answer.get(i-1).get(k-1) + answer.get(i-1).get(k);
        //                 row.add(sum);
        //             }
        //         }
        //         answer.add(row);
        //     }
        // }
        
        return answer;
    }
}