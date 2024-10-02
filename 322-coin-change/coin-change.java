class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, Integer.MAX_VALUE-1);
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < amount+1; j++){
                int notPick = dp[i-1][j];
                int pick = Integer.MAX_VALUE;
                if(coins[i-1] <= j){
                    pick = 1 + dp[i][j - coins[i-1]];
                }

                dp[i][j] = Math.min(pick, notPick);
            }
        }
        
        return dp[n][amount] == Integer.MAX_VALUE-1 ? -1 : dp[n][amount];
    }

    public int solve(int[] coins, int target, int idx, int[][] dp){
        if(target == 0){
            return 0;
        }

        if(idx < 0 || target < 0){
            return Integer.MAX_VALUE;
        }

        if(dp[idx][target] != -1){
            return dp[idx][target];
        }

        int notPick = solve(coins, target, idx-1, dp);
        int pick = Integer.MAX_VALUE;
        if(coins[idx] <= target){
            int subResult = solve(coins, target - coins[idx], idx, dp);
            if (subResult != Integer.MAX_VALUE) {
                pick = 1 + subResult;
            }
        }

        return dp[idx][target] = Math.min(pick, notPick);
    }
}