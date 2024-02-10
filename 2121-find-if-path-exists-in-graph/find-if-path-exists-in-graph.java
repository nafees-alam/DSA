class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] vis = new boolean[n];
        ArrayList<Integer> [] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        return helper(graph, source, destination, vis);
    }

    static boolean helper(ArrayList<Integer> [] graph, int src, int dest, boolean[] vis){
        if(src == dest){
            return true;
        }

        vis[src] = true;

        for(int node : graph[src]){
            if(!vis[node] && helper(graph, node, dest, vis)){
                return true;
            }
        }
            
            return false;
    }
}