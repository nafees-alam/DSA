class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];

        //base case
        ahead[1] = 0;
        ahead[0] = 0;

        //loop for buy and idx
        for(int i = n-1; i >= 0; i--){
            for(int j = 1; j >= 0; j--){
                if(j == 1){
                    curr[j] = Math.max(-prices[i] + ahead[0], ahead[1]);
                } else {
                    curr[j] = Math.max(prices[i] + ahead[1], ahead[0]);
                }
            }

            ahead = curr;
        }

        return curr[1];
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