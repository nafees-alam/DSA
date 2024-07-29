class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, -1, 0, 1};

        
        for(int i = 0; i < m; i++){
            //first row
            if(vis[0][i] == 0 && board[0][i] == 'O'){
                dfs(board, vis, delrow, delcol, 0, i);
            }
            //last row
            if(vis[n-1][i] == 0 && board[n-1][i] == 'O'){
                dfs(board, vis, delrow, delcol, n-1, i);
            }
        }

        for(int i = 0; i < n; i++){
            //first col
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(board, vis, delrow, delcol, i, 0);
            }
            //last col
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(board, vis, delrow, delcol, i, m-1);
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    static void dfs(char[][] board, int[][] vis, int[] delrow, int[] delcol, int row, int col){
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < 4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
             && vis[nrow][ncol] == 0 && board[nrow][ncol] == 'O'){
                dfs(board, vis, delrow, delcol, nrow, ncol);
             }
        }
    }
}