class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, nums.length-1, dp);
    }

    int solve(int[] arr, int idx, int[] dp){
        if(idx < 0){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }

        int notPick = solve(arr, idx-1, dp);
        int pick = arr[idx] + solve(arr, idx-2, dp);

        return dp[idx] = Math.max(pick, notPick);
    }
}