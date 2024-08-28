class Solution {
    boolean isSubIsland;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int ans = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1){
                    isSubIsland = true;
                    dfs(grid1, grid2, i, j);
                    if(isSubIsland){
                    ans++;
                    }
                }
            }
        }

        return ans;
    }
    
    public void dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length || grid2[i][j] == 0){
            return;
        }

        if(grid1[i][j] != grid2[i][j]){
            isSubIsland = false;
        }

        grid2[i][j] = 0;

        dfs(grid1, grid2, i+1, j);
        dfs(grid1, grid2, i-1, j);
        dfs(grid1, grid2, i, j+1);
        dfs(grid1, grid2, i, j-1);
    }
}