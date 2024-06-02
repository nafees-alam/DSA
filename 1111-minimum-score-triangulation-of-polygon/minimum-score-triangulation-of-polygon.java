class Solution {
    public int minScoreTriangulation(int[] values) {
        int[][] dp = new int[values.length][values.length];
        for(int i = 0; i < values.length; i++){
            for(int j = 0; j < values.length; j++){
                dp[i][j] = -1;
            }
        }
        return minScore(values, 1, values.length - 1, dp);
        
    }

    static int minScore(int[] arr, int i, int j, int[][] dp){
        if(i == j){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int cost1 = minScore(arr, i, k, dp);
            int cost2 = minScore(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            int finalCost = cost1+cost2+cost3;
            ans = Math.min(ans, finalCost);
        }
        return dp[i][j] = ans;
    }
}