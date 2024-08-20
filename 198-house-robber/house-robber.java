class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(nums, n-1, dp);
    }

    public int helper(int[] nums, int idx, int[] dp){
        if(idx == 0){
            return nums[0];
        }
        if(idx < 0){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }

        int pick = nums[idx] + helper(nums, idx-2, dp);
        int notPick = helper(nums, idx-1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }
}