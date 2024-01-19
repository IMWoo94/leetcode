import java.math.*;

class Solution {
    public String addBinary(String a, String b) {
        
        // 2진수 인 것을 명시하여 bigInter 생성
//         BigInteger bigIntegerA = new BigInteger(a, 2);
//         BigInteger bigIntegerB = new BigInteger(b, 2);
        
//         return bigIntegerA.add(bigIntegerB).toString(2);
        
        // 
        int aIndex = a.length() -1;
        int bIndex = b.length() -1;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        
        while(aIndex >= 0 || bIndex >= 0){
            if(aIndex >= 0){
                sum += a.charAt(aIndex--) - '0';
            }
            if(bIndex >= 0){
                sum += b.charAt(bIndex--) - '0';
            }
            
            sb.append(sum%2);
            sum /= 2;
        }
        
        if(sum == 1){
            sb.append(sum);
        }
        String answer = sb.reverse().toString();
        return answer;
    }
}