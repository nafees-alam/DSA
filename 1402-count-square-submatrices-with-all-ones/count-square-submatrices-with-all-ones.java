class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int res = 0;
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 1){
                    res += solve(i, j, matrix, dp);
                }
            }
        }

        return res;
    }

    int solve(int i, int j, int[][] matrix, int[][] dp){
        if(i >= matrix.length || j >= matrix[0].length){
            return 0;
        }

        if(matrix[i][j] == 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        //right
        int right = solve(i, j+1, matrix, dp);
        //down
        int down = solve(i+1, j, matrix, dp);
        //diagonal
        int dia = solve(i+1, j+1, matrix, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(down, dia));
    }
}