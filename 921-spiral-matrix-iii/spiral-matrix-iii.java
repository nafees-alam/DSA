class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[cols * rows][2];
        int total = rows*cols;
        ans[0][0] = rStart;
        ans[0][1] = cStart;
        int count = 1;
        int steps = 1;
        int idx = 0;
        int[] delrow = {0, 1, 0, -1};
        int[] delcol = {1, 0, -1, 0};

        while(count < total){
           for(int times = 0; times < 2; times++){
            int nrow = delrow[idx%4];
            int ncol = delcol[idx%4];
            for(int i = 0; i < steps; i++){
                rStart += nrow;
                cStart += ncol;
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                    ans[count][0] = rStart;
                    ans[count][1] = cStart;
                    count++;
                }
            }

            idx++;
           }
           
           steps++;
        }

        return ans;
    }
}