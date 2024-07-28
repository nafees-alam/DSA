class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int countFresh = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    countFresh++;
                }
            }
        }

        int count = 0;
        int[] delrow = {+1, 0, -1, 0};
        int[] delcol = {0, -1, 0, +1};
        int time = 0;

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().time;
            q.remove();
            time = Math.max(t, time);

            for(int i = 0; i < 4; i++){
                int ro = row + delrow[i];
                int co = col + delcol[i];

                if(ro >= 0 && ro < n && co >= 0 && co < m
                && vis[ro][co] == 0 && grid[ro][co] == 1){
                    q.add(new Pair(ro, co, t+1));
                    vis[ro][co] = 2;
                    count++;
                }
            }
        }

        if(count != countFresh) return -1;
        return time;
    }
}

class Pair {
    int first;
    int second;
    int time;

    public Pair(int i, int j, int k){
        this.first = i;
        this.second = j;
        this.time = k;
    }
}