class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        int f1 = helper2(nums, n-1,dp1);
        int f2 = helper1(nums, n-2,dp2);

        return Math.max(f1, f2);
    }

    public int helper1(int[] arr, int idx, int[] dp){
        if(idx == 0){
            return arr[0];
        }
        if(idx < 0){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int pick = arr[idx] + helper1(arr, idx-2, dp);
        int notPick = helper1(arr, idx-1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }

    public int helper2(int[] arr, int idx, int[] dp){
        if(idx <= 0){
            return 0;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }
        
        int pick = arr[idx] + helper2(arr, idx-2, dp);
        int notPick = helper2(arr, idx-1, dp);

        return dp[idx] = Math.max(pick, notPick);
    }
}