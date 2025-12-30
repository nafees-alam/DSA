class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        if(n < 3 || m < 3){
            return 0;
        }
        for(int row = 0; row < n-2; row++){
            for(int col = 0; col < m-2; col++){
                if(!validMatrix(grid, row, col)){
                    continue;
                }
                //rows check
                int rsum1 = grid[row][col]+grid[row][col+1]+grid[row][col+2];
                int rsum2 = grid[row+1][col]+grid[row+1][col+1]+grid[row+1][col+2];
                int rsum3 = grid[row+2][col]+grid[row+2][col+1]+grid[row+2][col+2];
                if(rsum1 != rsum2 || rsum2 != rsum3){
                    continue;
                }
                //col check
                int csum1 = grid[row][col]+grid[row+1][col]+grid[row+2][col];
                int csum2 = grid[row][col+1]+grid[row+1][col+1]+grid[row+2][col+1];
                int csum3 = grid[row][col+2]+grid[row+1][col+2]+grid[row+2][col+2];
                if(csum1 != csum2 || csum2 != csum3 || csum1 != rsum1){
                    continue;
                }

                //dia check
                int dia1 = grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
                int dia2 = grid[row+2][col]+grid[row+1][col+1]+grid[row][col+2];
                if(dia1 != dia2 || dia1 != rsum1 || dia1 != csum1){
                    continue;
                }

                ans++;
            }
        }

        return ans;
    }

    public boolean validMatrix(int[][] grid, int row, int col){
        int[] check = new int[10];
        for(int i = row; i <= row+2; i++){
            for(int j = col; j <= col+2; j++){
                if(grid[i][j] > 9 || grid[i][j] < 1) return false;
                if(check[grid[i][j]-1] != 0) return false;
                check[grid[i][j]-1] = 1;
            }
        }

        return true;
    }
}