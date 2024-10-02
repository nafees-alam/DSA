class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int result = solve(coins, amount, n-1, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
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