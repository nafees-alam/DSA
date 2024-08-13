class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return unique(0, 0, n, m, dp);
    }
    public int unique(int i, int j, int n, int m, int[][] dp){
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(i == n || j == m){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int right = unique(i, j+1, n, m, dp);
        int left = unique(i+1, j, n, m, dp);

        return dp[i][j] = left + right;
    }
}