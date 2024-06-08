class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                dp[i][j] = - 1;
            }
        }
        return minPath(grid, 0, 0, dp);
    }

    static int minPath(int[][] arr, int i, int j, int[][] dp){
        if(i == arr.length-1 && j == arr[0].length-1){
            return arr[i][j];
        } else if(i > arr.length-1){
            return Integer.MAX_VALUE;
        } else if(j > arr[0].length-1){
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int right = minPath(arr, i, j+1, dp);
        int down = minPath(arr, i+1, j, dp);
        dp[i][j] = arr[i][j] + Math.min(right, down);
        return dp[i][j];
    }
}