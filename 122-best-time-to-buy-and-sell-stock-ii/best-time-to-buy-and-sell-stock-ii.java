class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        //base case
        dp[n][1] = 0;
        dp[n][0] = 0;

        //loop for buy and idx
        for(int i = n-1; i >= 0; i--){
            for(int j = 1; j >= 0; j--){
                if(j == 1){
                    dp[i][j] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);
                } else {
                    dp[i][j] = Math.max(prices[i] + dp[i+1][1], dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
    }

    public int solve(int[] arr, int idx, int buy, int[][] dp){
        if(idx == arr.length){
            return 0;
        }
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int profit = 0;
        if(buy == 1){
            int buyy = -arr[idx] + solve(arr, idx+1, 0, dp);
            int notBuyy = 0 + solve(arr, idx+1, 1, dp);
            profit = Math.max(buyy, notBuyy);
        } else {
            int sell = arr[idx] + solve(arr, idx+1, 1, dp);
            int notSell = 0 + solve(arr, idx+1, 0, dp);
            profit = Math.max(sell, notSell);
        }

        return dp[idx][buy] = profit;
    }
}