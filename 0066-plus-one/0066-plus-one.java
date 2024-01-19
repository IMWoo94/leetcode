class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        int answer[];
        // 추가 대상의 값이 9 이하면 +1 
        // 추가 대상의 값이 9 인 경우 0 처리 및 앞자리 수 +1
        add(digits, len);
        
        // +1 이 완료 되고 나서 배열의 맨 앞자의 수가 0 이라면 배열 추가
        if(digits[0] == 0){
            answer = new int[digits.length+1];
            answer[0] = 1;
            System.arraycopy( digits, 0, answer, 1, digits.length );
        }else{
            answer = digits;
        }

        return answer;
    }
    
    public void add(int[] digits, int size){
        if(size < 0 ){
            return;
        }
        if(digits[size] < 9){
            digits[size] = digits[size] + 1;
            return;
        }else{
            digits[size] = 0;
            add(digits, size-1);
        }
    }
}