class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};
        int count = 0;

        for(int i = 0; i < m; i++){
            if(vis[0][i] == 0 && grid[0][i] == 1){
                dfs(grid, vis, 0, i, delrow, delcol);
            }
            if(vis[n-1][i] == 0 && grid[n-1][i] == 1){
                dfs(grid, vis, n-1, i, delrow, delcol);
            }
        }
        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && grid[i][0] == 1){
                dfs(grid, vis, i, 0, delrow, delcol);
            }
            if(vis[i][m-1] == 0 && grid[i][m-1] == 1){
                dfs(grid, vis, i, m-1, delrow, delcol);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int[][] grid, int[][] vis, int row, int col, int[] delrow, int[] delcol){
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < 4; i++){
            int ro = row + delrow[i];
            int co = col + delcol[i];

            if(ro >= 0 && ro < n && co >= 0 && co < m
            && vis[ro][co] == 0 && grid[ro][co] == 1){
                dfs(grid, vis, ro, co, delrow, delcol);
            }
        }
    }
}