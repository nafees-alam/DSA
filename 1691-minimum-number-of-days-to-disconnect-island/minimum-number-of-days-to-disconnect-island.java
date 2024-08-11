class Solution {
    public int minDays(int[][] grid) {
        int count = countIslands(grid, 0);
        if(count != 1) return 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(countIslands(grid, 0) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    static int countIslands(int[][] grid, int count){
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};
        int[][] vis = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                    dfs(i, j, grid, vis, drow, dcol);
                }
            }
        }

        return count;
    }

    static void dfs(int row, int col, int[][] grid, int[][] vis, int[] drow, int[] dcol){
        vis[row][col] = 1;
            for(int i = 0; i < 4; i++){
                int nr = row + drow[i];
                int nc = col + dcol[i];

                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && 
                grid[nr][nc] == 1 && vis[nr][nc] == 0){
                    dfs(nr, nc, grid, vis, drow, dcol);
                }
            }
    }
}