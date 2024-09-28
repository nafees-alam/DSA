class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i-1][j] == 1)
                adj.get(i).add(j+1);
            }
        }

        int cnt = 0;

        int[] vis = new int[n+1];
        for(int i = 1; i <= n; i++){
            if(vis[i] == 0){
                cnt++;
                bfs(adj, i, vis);
            }
        }

        return cnt;
    }

    public void bfs(List<List<Integer>> adj, int currNode, int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(currNode);

        while(!q.isEmpty()){
            int curr = q.remove();
            if(vis[curr] == 0){
                vis[curr] = 1;
                for(int dest : adj.get(curr)){
                    if(vis[dest] == 0){
                        q.add(dest);
                    }
                }
            }
        }
    }
}