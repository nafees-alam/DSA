class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
       List<List<Integer>> adj = new ArrayList<>();
       for(int i = 0; i < n; i++){
        adj.add(new ArrayList<>());
       }

       for(int i = 0; i < connections.size(); i++){
        int u = connections.get(i).get(0);
        int v = connections.get(i).get(1);
        adj.get(u).add(v);
        adj.get(v).add(u);
       }

       int tin[] = new int[n];
       int low[] = new int[n];
       int vis[] = new int[n];
       List<List<Integer>> bridge = new ArrayList<>();

       dfs(0, -1, adj, low, tin, vis, bridge);

       return bridge; 
    }

    private int timer = 1;
    private void dfs(int curr, int par, List<List<Integer>> adj, int[] low, int[] tin, int[] vis, List<List<Integer>> bridge){
        vis[curr] = 1;
        low[curr] = tin[curr] = timer;
        timer++;
        for(int adjNode : adj.get(curr)){
            if(adjNode == par) continue;
            if(vis[adjNode] == 0){
                dfs(adjNode, curr, adj, low, tin, vis, bridge);

                low[curr] = Math.min(low[curr], low[adjNode]);
                if(low[adjNode] > tin[curr]){
                    bridge.add(Arrays.asList(adjNode, curr));
                }
            } else {
                low[curr] = Math.min(low[curr], low[adjNode]);
            }
        }
    }
}