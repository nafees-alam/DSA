class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        return lis(nums, -1, 0, dp);
    }

    public int lis(int[] nums, int prevIdx, int idx, int[][] dp){
        if(idx == nums.length){
            return 0;
        }
        
        if(dp[prevIdx+1][idx] != -1){
            return dp[prevIdx+1][idx];
        }

        int notTake = lis(nums, prevIdx, idx+1, dp);
        int take = 0;
        if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
            take = 1 + lis(nums, idx, idx+1, dp);
        }

        return dp[prevIdx+1][idx] = Math.max(take, notTake);
    }
}