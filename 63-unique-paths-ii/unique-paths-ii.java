class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return helper(obstacleGrid, m-1, n-1, dp);
    }

    public int helper(int[][] grid, int i, int j, int[][] dp){
        if(i == 0 && j == 0){
            if(grid[i][j] != 0){
                return 0;
            }
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = 0;
        int left = 0;
        if(grid[i][j] == 0){
            up = helper(grid, i-1, j, dp);
            left = helper(grid, i, j-1, dp);
        }

        return dp[i][j] = up+left;
    }
}