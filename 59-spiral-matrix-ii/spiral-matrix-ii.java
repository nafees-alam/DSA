class Solution {
    public int[][] generateMatrix(int n) {
        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = n-1;

        int[][] ans = new int[n][n];
        int count = 1;
        int total = n * n;

        while(count <= total){
            //top line
            for(int i = left; i <= right; i++){
                ans[top][i] = count;
                count++;
            }
            top++;
            //right line
            for(int i = top; i <= bottom; i++){
                ans[i][right] = count;
                count++;
            }
            right--;
            //bottom line
            for(int i = right; i >= left; i--){
                ans[bottom][i] = count;
                count++;
            }
            bottom--;
            //left line
            for(int i = bottom; i >= top; i--){
                ans[i][left] = count;
                count++;
            }
            left++;
        }

        return ans;
    }
}