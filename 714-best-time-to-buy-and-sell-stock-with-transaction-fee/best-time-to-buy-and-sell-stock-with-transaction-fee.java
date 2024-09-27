class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return solve(prices, 0, 1, dp, fee);
    }

    int solve(int[] arr, int idx, int buy, int[][] dp, int fee){
        if(idx == arr.length){
            return 0;
        }
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[idx] + solve(arr, idx+1, 0, dp, fee), solve(arr, idx+1, 1, dp, fee));
        } else {
            profit = Math.max(arr[idx] + solve(arr, idx+1, 1, dp, fee) - fee, solve(arr, idx+1, 0, dp, fee));
        }

        return dp[idx][buy] = profit;
    }
}