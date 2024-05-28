class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return dpApp(n, dp);
    }

    static int dpApp(int n, int[] dp){
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += dpApp(i, dp) * dpApp(n-i-1, dp);
        }

        return dp[n] = ans;
    }
}