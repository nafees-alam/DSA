class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            graph.get(arr[1]).add(arr[0]);
        }

        return !detectCycle(graph);
    }

    static boolean detectCycle(ArrayList<ArrayList<Integer>> graph){
        boolean vis[] = new boolean[graph.size()];
        boolean stack[] = new boolean[graph.size()];
        for(int i = 0; i < graph.size(); i++){
            if(!vis[i]){
                if(detectCycleUtil(graph, vis, i, stack)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean detectCycleUtil(ArrayList<ArrayList<Integer>> graph, boolean[] vis, int curr, boolean[] stack){
        vis[curr] = true;
        stack[curr] = true;
        for(int i = 0; i < graph.get(curr).size(); i++){
            int e = graph.get(curr).get(i);

            if(stack[e]){
                return true;
            }
            if(!vis[e]){
                if(detectCycleUtil(graph, vis, e, stack)){
                    return true;
                }
            }
        }

        stack[curr] = false;

        return false;
    }
}