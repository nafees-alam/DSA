class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr, -2);
        }
        // for(int i = 0; i < dp.length; i++){
        //     dp[i][0] = matrix[i][0];
        // }
        for(int j = 0; j < matrix[0].length; j++){
            int val = helper(matrix, 0, j, dp);
            min = Math.min(min, val);
        }

        return min;
    }

    public int helper(int[][] mat, int row, int col,int[][] dp){
        if(col < 0 || col >= mat[0].length){
            return (int)1e9;
        }

        if(row == mat.length-1){
            return mat[row][col];
        }

        if(dp[row][col] != -2){
            return dp[row][col];
        }

        //down
        int down = helper(mat, row+1, col, dp) + mat[row][col];
        // dia left
        int diaLeft = helper(mat, row+1, col-1, dp) + mat[row][col];
        // dia right
        int diaRight = helper(mat, row+1, col+1, dp) + mat[row][col];

        return dp[row][col] = Math.min(down, Math.min(diaLeft, diaRight));
    }
}