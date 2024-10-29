class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;

        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for(int i = 0; i < m; i++){
            int temp = solve(grid, i, 0, m, n, dp)-1;
            max = Math.max(max, temp);
        }

        return max;
    }

    public int solve(int[][] grid, int i, int j, int m, int n, int[][] dp){
        if(i >= m || j >= n ||i < 0 || j < 0){
            return 0;
        }

        int diaUp = 0;
        int right = 0;
        int diaDown = 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //dia up
        if(i > 0 && j < n-1 && grid[i][j] < grid[i-1][j+1])
            diaUp = solve(grid, i-1, j+1, m, n, dp);
        //right
        if(j < n-1 && grid[i][j] < grid[i][j+1])
            right = solve(grid, i, j+1, m, n, dp);
        //dia down
        if(i < m-1 && j < n-1 && grid[i][j] < grid[i+1][j+1])
            diaDown = solve(grid, i+1, j+1, m, n, dp);

        return  dp[i][j] = 1 + Math.max(diaUp, Math.max(right, diaDown));
    }
}