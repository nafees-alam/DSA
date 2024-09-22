class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i = 0; i < dp.length; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int pick = 0;
                if(coins[i-1] <= j){
                    pick = dp[i][j - coins[i-1]];
                }
                int notPick = dp[i-1][j];

                dp[i][j] = pick + notPick;
            }
        }

        return dp[coins.length][amount];
    }

    int ways(int[] arr, int sum, int idx, int[][] dp){
        if(sum == 0){
            return 1;
        }

        if(idx < 0 || sum < 0){
            return 0;
        }

        if(dp[idx][sum] != -1){
            return dp[idx][sum];
        }

        int pick = ways(arr, sum - arr[idx], idx, dp);

        int notPick = ways(arr, sum, idx - 1, dp);

        return dp[idx][sum] = pick + notPick;
    }
}