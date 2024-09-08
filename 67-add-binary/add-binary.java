class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int n = a.length();
        int m = b.length();
        char[] st2;
        char[] st1;
        if(m > n){
            st2 = a.toCharArray();
            st1 = b.toCharArray();
        } else {
            st1 = a.toCharArray();
            st2 = b.toCharArray();
        }
        int k = st2.length-1;
        for(int i = st1.length-1; i >= 0; i--){
            int first = st1[i] - '0';
            int second = 0;
            if(k >= 0){
                second = st2[k--] - '0';
            }
            int sum = first + second + carry;
            if(sum == 2){
                sb.insert(0, 0);
                carry = 1;
            } else if(sum == 3){
                sb.insert(0, 1);
                carry = 1;
            } else {
                sb.insert(0, sum);
                carry = 0;
            }
        }

        if(carry == 1){
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}