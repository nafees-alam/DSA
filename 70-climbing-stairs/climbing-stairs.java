class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return dpApp(n, dp);
    }

    static int dpApp(int n, int[] dp){
        if(n == 1 || n == 2){
            return n;
        }

        if(dp[n] != 0){
            return dp[n];
        }

        return dp[n] = dpApp(n-1, dp) + dpApp(n-2, dp);
    }
}