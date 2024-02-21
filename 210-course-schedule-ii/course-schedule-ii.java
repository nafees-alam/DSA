class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] inDeg = new int[numCourses];

        //initialise the list with new arraylists
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //finding the inDegree
        for(int i = 0; i < numCourses; i++){
            for(int j = 0; j < graph.get(i).size(); j++){
                inDeg[graph.get(i).get(j)]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        //add nodes with 0 inDegree in the queue
        for(int i = 0; i < inDeg.length; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;

        while(!q.isEmpty()){
            int curr = q.remove();
            ans[i++] = curr;
            for(int j = 0; j < graph.get(curr).size(); j++){
                inDeg[graph.get(curr).get(j)]--;
                if(inDeg[graph.get(curr).get(j)] == 0){
                    q.add(graph.get(curr).get(j));
                }
            }
        }

        if(i == numCourses){
            return ans;
        }

        return new int[0];
        
    }
}