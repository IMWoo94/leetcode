class Solution {
    public int mySqrt(int x) {
//         long answer = 1;
        
//         // 1 부터 수를 올리면서 제곱의 값이 x 를 넘어가는 수
//         // x 를 넘어간다면 1을 뺀 값이 해당 제곱근
//         while(true){
//             if(answer * answer > x){
//                 return (int)(answer-1);
//             }
//             answer += 1;
//         }
        
        // 이진 탐색
        // mid * mid <= x < (mid + 1) * (mid + 1)
        long start = 0;
        long end = x;
        
        while(start <= end){
            long mid = (start + end) / 2;
            if (mid * mid <= x && x < ( mid+1 ) * ( mid+1 )) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return (int)start;
    }
}