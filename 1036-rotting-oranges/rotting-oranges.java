class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<Tuple> q = new LinkedList<>();
        int fresh = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    q.add(new Tuple(i, j, 0));
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int cnt = 0;
        int time = 0;
    
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().time;
            q.remove();
            time = t;

            for(int i = 0; i < 4; i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1){
                    grid[nrow][ncol] = 2;
                    q.add(new Tuple(nrow, ncol, t+1));
                    cnt++;
                }
            }
        }

        if(cnt != fresh) {
            return -1;
        }

        return time;
    }
}

class Tuple{
    int first;
    int second;
    int time;

    public Tuple(int i, int j, int k){
        first = i;
        second = j;
        time = k;
    }
}