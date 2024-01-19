import java.math.*;

class Solution {
    public String addBinary(String a, String b) {
        
        // 2진수 인 것을 명시하여 bigInter 생성
        BigInteger bigIntegerA = new BigInteger(a, 2);
        BigInteger bigIntegerB = new BigInteger(b, 2);
        
        return bigIntegerA.add(bigIntegerB).toString(2);
    }
}