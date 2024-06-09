class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int W = sum/2;
        int[][] dp = new int[n+1][W+1];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < W+1; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = Math.max(nums[i-1] + dp[i-1][j - nums[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        double sum1 = dp[n][W];
        return sum1 == (double)sum/2;
    }
}