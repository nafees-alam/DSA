class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];

        return dpApp(n, dp);
    }

    static int dpApp(int n, int[] dp){
        if(n == 0 || n == 1){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        dp[n] = dpApp(n-1, dp) + dpApp(n-2, dp);
        return dp[n];
    }
}