class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], succProb[i]));
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start_node, 1));
        double[] dist = new double[n];
        Arrays.fill(dist, 0);
        dist[start_node] = 0;

        while(!q.isEmpty()){
            int node = q.peek().node;
            double prob = q.peek().prob;
            q.remove();

            for(Pair it : adj.get(node)){
                int currNode = it.node;
                double currProb = it.prob;

                if(prob * currProb > dist[currNode]){
                    dist[currNode] = prob * currProb;
                    q.add(new Pair(currNode, dist[currNode]));
                }
            }
        }
         System.out.println(Arrays.toString(dist));
        return dist[end_node]; 
    }
}

class Pair{
    int node;
    double prob;

    public Pair(int node, double prob){
        this.node = node;
        this.prob = prob;
    }
}