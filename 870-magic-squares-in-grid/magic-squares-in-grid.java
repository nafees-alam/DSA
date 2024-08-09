class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows-2; i++){
            for(int j = 0; j < cols-2; j++){
                if(isMagicMatrix(grid, i, j))
                count++;
            }
        }
        return count;
    }

    static int findRowSum(int[][] grid, int r, int c){
        boolean[] vis = new boolean[10];
        int sum = 0;
        for(int i = 0; i < 3; i++){
            int rSum = 0;
            for(int j = 0; j < 3; j++){
                int val = grid[r+i][c+j];
                if(val == 0 || val >= 10 || vis[val]){
                    return -1;
                }
                vis[val] = true;
                rSum += val;
            }
            if(i == 0){
                sum = rSum;
            } else if(sum != rSum){
                return -1;
            }
        }
        return sum;
    }

    static int findColSum(int[][] grid, int r, int c){
        int sum = 0;
        for(int i = 0; i < 3; i++){
            int cSum = 0;
            for(int j = 0; j < 3; j++){
                int val = grid[r+j][c+i];
                cSum += val;
            }
            if(i == 0){
                sum = cSum;
            } else if(sum != cSum){
                return -1;
            }
        }
        return sum;
    }

    static int findDiaSum(int[][] grid, int r, int c){
        int sum1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        int sum2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
        if(sum1 == sum2){
            return sum1;
        } else {
            return -1;
        }
    }

    static boolean isMagicMatrix(int[][] grid, int r, int c){
        int rSum = findRowSum(grid, r, c);
        if(rSum == -1) return false;
        int colSum = findColSum(grid, r, c);
        if(colSum == -1) return false;
        int diaSum = findDiaSum(grid, r, c);
        if(diaSum == -1) return false;

        if(colSum == rSum && colSum == diaSum) return true;

        return false;
    }
}