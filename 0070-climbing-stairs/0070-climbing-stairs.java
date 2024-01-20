class Solution {
    public int climbStairs(int n) {
        /* 
        1: 1개
        1
            
        2: 2개
        1 + 1
        2
            
        3: 3개
        1 + 1 + 1
        1 + 2
        2 + 1
        
        
        4: 5개
        1 + 1 + 1 + 1
        2 + 1 + 1
        1 + 2 + 1
        1 + 1 + 2
        2 + 2
            
        5: 8개
        1 + 1 + 1 + 1 + 1
        2 + 1 + 1 + 1
        1 + 2 + 1 + 1
        1 + 1 + 2 + 1
        1 + 1 + 1 + 2
        2 + 2 + 1
        2 + 1 + 2
        1 + 2 + 2
        
        계단을 1개 혹은 2개를 올라가는 방법에 대해서 나열하다 보면 규칙이 보인다.
        여기서 발견되는 규칙은 n 단계에서 올라가는 방법의 갯수는 n - 1 단계 + n - 2 단계의 갯수이다.
        */
        
        int[] dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2]; 
        }
            
        return dp[n];

    }
}