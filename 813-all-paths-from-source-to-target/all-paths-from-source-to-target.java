class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        helper(graph, list, ll, 0, graph.length - 1);
        return list;
    }

    static void helper(int[][] graph, List<List<Integer>> list, List<Integer> currentPath, int src, int dest){
        //adds source after every recursion call
        currentPath.add(src);

        // check if we reached the destination
        if(src == dest){
            list.add(new ArrayList<>(currentPath));
            return;
        }
        
        for(int i = 0; i < graph[src].length; i++){
            helper(graph, list, currentPath, graph[src][i], dest);
            //remove nodes from currentPath while backtracing(V.V.I.)
            currentPath.remove(currentPath.size() - 1);
        }
    }
}