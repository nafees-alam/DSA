class Solution {
    public int lengthOfLIS(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        int[] arr = new int[set.size()];
        int i = 0;

        for(int val : set){
            arr[i] = val;
            i++;
        }

        Arrays.sort(arr);

        return lcs(nums, arr);
    }

    static int lcs(int[] nums, int[] arr){
        int n = nums.length;
        int m = arr.length;
        int[][] dp = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for(int j = 0; j < m+1; j++){
            dp[0][j] = 0;
        }

        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(nums[i-1] == arr[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}