class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(prices, 0, 1, dp);
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