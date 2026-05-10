class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] arr : dp){
            Arrays.fill(arr, -2);
        }

        return dp(nums, 1, 0, target, dp);
    }

    static int dp(int[] arr, int i, int currIdx, int target, int[][] dp){
        if(currIdx == arr.length-1){
            return 0;
        }

        if(i == arr.length) return -1;

        if(dp[i][currIdx] != -2) return dp[i][currIdx];

        int diff = arr[i] - arr[currIdx];

        int found = -1;
        if(Math.abs(diff) <= target){
            int next = dp(arr, i+1, i, target, dp);
            //Found
            if(next !=-1){
                found = 1 + next;
            }
        }

        //Not found
        int notFound = dp(arr, i+1, currIdx, target, dp);

        return dp[i][currIdx] = Math.max(found, notFound);
    }
}