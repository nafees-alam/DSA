class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(vis[i] == 0){
                isCycle(graph, vis, pathVis, i, check);
            }
        }

        for(int i = 0; i < n; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }

        return ans;
    }

    static boolean isCycle(int[][] graph, int[] vis, int[] pathVis, int curr, int[] check){
        vis[curr] = 1;
        pathVis[curr] = 1;

        for(int i = 0; i < graph[curr].length; i++){
            int adjNode = graph[curr][i];
            if(vis[adjNode] == 0){
                if(isCycle(graph, vis, pathVis, adjNode, check)){
                    return true;
                }
            } else if(pathVis[adjNode] == 1){
                return true;
            }
        }

        check[curr] = 1;
        pathVis[curr] = 0;
        return false;
    }
}