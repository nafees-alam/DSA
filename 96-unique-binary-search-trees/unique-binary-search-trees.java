class Solution {
    public int numTrees(int n) {
        if(n == 0 || n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        if(dp[n] != 0){
            return dp[n];
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += numTrees(i) * numTrees(n-i-1);
        }
        dp[n] = ans;

        return dp[n];
    }
}