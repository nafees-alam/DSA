class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int rowSt = 0;
        int rowEn = m-1;
        int colSt = 0;
        int colEn = n-1;
        while((rowEn > rowSt && colEn > colSt)){
            ArrayList<Integer> list = new ArrayList<>();
            int rowAnsSt = rowSt;
            int rowAnsEn = rowEn;
            int colAnsSt = colSt;
            int colAnsEn = colEn;
            //left;
            for(int i = rowSt; i <= rowEn; i++){
                list.add(grid[i][colSt]);
            }
            colSt++;
            //down
            for(int j = colSt; j <= colEn; j++){
                list.add(grid[rowEn][j]);
            }
            rowEn--;
            //right
            for(int i = rowEn; i >= rowSt; i--){
                list.add(grid[i][colEn]);
            }
            colEn--;
            //top
            for(int j = colEn; j >= colSt; j--){
                list.add(grid[rowSt][j]);
            }
            rowSt++;

            int temp = k % list.size();

            //rotate
            while(temp > 0){
                int num = list.get(list.size()-1);
                list.add(0, num);
                list.remove(list.size()-1);
                temp--;
            }

            //left;
            int cntr = 0;
            for(int i = rowAnsSt; i <= rowAnsEn; i++){
                grid[i][colAnsSt] = list.get(cntr++);
            }
            colAnsSt++;
            //down
            for(int j = colAnsSt; j <= colAnsEn; j++){
                grid[rowAnsEn][j] = list.get(cntr++);
            }
            rowAnsEn--;
            //right
            for(int i = rowAnsEn; i >= rowAnsSt; i--){
                grid[i][colAnsEn] = list.get(cntr++);
            }
            colAnsEn--;
            //top
            for(int j = colAnsEn; j >= colAnsSt; j--){
                grid[rowAnsSt][j] = list.get(cntr++);
            }
            rowAnsSt++;
        }

        return grid;
    }
}