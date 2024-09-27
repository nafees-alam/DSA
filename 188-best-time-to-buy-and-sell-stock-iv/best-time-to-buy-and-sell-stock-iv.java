class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] arr : dp){
            for(int[] it : arr){
                Arrays.fill(it, -1);
            }
        }

        return solve(prices, 0, 1, k, dp);
    }

    public int solve(int[] arr, int idx, int buy, int cnt, int[][][] dp){
        if(idx == arr.length || cnt == 0){
            return 0;
        }

        if(dp[idx][buy][cnt] != -1){
            return dp[idx][buy][cnt];
        }

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-arr[idx] + solve(arr, idx+1, 0, cnt, dp), solve(arr, idx+1, 1, cnt, dp));
        } else {
            profit = Math.max(arr[idx] + solve(arr, idx+1, 1, cnt-1, dp), solve(arr, idx+1, 0, cnt, dp));
        }

        return dp[idx][buy][cnt] = profit;
    }
}