class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return ways(coins, amount, coins.length-1, dp);
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