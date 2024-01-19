class Solution {
    public int mySqrt(int x) {
        long answer = 1;
        
        // 1 부터 수를 올리면서 제곱의 값이 x 를 넘어가는 수
        // x 를 넘어간다면 1을 뺀 값이 해당 제곱근
        while(true){
            if(answer * answer > x){
                return (int)(answer-1);
            }
            answer += 1;
        }
        
        // 이진 탐색
//         int start = 1;
//         int end = x;
        
//         while(start <= end){
//             long mid = (start + end) / 2;
//             if(mid * mid == x){
//                 return (int)mid;
//             }else if(mid * mid < x){
//                 start = (int)mid + 1;
//             }else{
//                 end = (int)mid - 1;
//             }
//         }
//         return start;
    }
}