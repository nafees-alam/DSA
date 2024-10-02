class Solution {
    public int reverse(int x) {
        String str = Integer.toString(x);
        int n = str.length()-1;
        int sign = 1;
        int ans = 0;
        int idx = 0;
        if(str.charAt(0) == '-'){
            sign = -1;
            idx = 1;
            n--;
        }
        for(int i = str.length()-1; i >= idx; i--){
            int t = str.charAt(i) - '0';
            ans += Math.pow(10, n) * t;
            System.out.println(ans);
            if(ans >= Integer.MAX_VALUE){
                return 0;
            }
            n--;
        }

        return sign*ans;
    }
}