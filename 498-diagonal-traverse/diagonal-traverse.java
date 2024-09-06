class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m*n];

        int row = 0;
        int col = 0;
        int k = 0;
        boolean flag = true;

        for(int i = 0; i < m+n-1; i++){
            //up
            if(flag){
                while(row >= 0 && col < n){
                    ans[k++] = mat[row][col];
                    row--;
                    col++;
                }

                col = i+1;
                row = 0;
                if(col >= n){
                    col = n-1;
                    row = i-col+1;
                }
            } else {  //down
                while(row < m && col >= 0){
                    ans[k++] = mat[row][col];
                    row++;
                    col--;
                }

                row = i+1;
                col = 0;
                if(row >= m){
                    row = m-1;
                    col = i-row+1;
                }
            }
            flag = !flag;
        }

        return ans;
    }
}