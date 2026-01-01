class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1] != 9){
            digits[n-1]++;
            return digits;
        }

        int carry = 1;
        digits[n-1] = 0;
        int i = n-2;
        while(carry > 0 && i >= 0){
            int num = (digits[i]+carry);
            digits[i--] = num % 10;
            carry = num / 10; 
        }

        int[] ans = new int[n+1];
        int idx = 0;
        if(carry > 0){
            ans[idx] = carry;
            for(int k = 0; k < n; k++){
                ans[k+1] = digits[k];
            }

            return ans;
        }

        return digits;
    }
}