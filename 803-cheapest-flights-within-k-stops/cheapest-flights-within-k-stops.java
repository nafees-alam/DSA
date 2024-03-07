class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //creating graph
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(flights, graph);

        int[] dist = new int[n];
        //intializing dist with infinity
        for(int i = 0; i < n; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k){
                break;
            }

            for(int i = 0; i < graph[curr.v].size(); i++){
                Edge e = graph[curr.v].get(i);
                int u = e.src;
                int v = e.des;
                int wt = e.wt;

                //relaxation
                if(dist[u] != Integer.MAX_VALUE && curr.cost + wt <= dist[v] && curr.stops <= k){
                    dist[v] = curr.cost + wt;
                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }

        if(dist[dst] == Integer.MAX_VALUE){
            return -1;
        } else {
            return dist[dst];
        }

    }

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.des = d;
            this.wt = w;
        }
    }

    static class Info{
        int v; //vertex
        int cost;
        int stops;

        public Info(int v, int c, int s){
            this.v = v;
            this.cost = c;
            this.stops = s;
        }
    }

    static void createGraph(int[][] flights, ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] arr : flights){
            graph[arr[0]].add(new Edge(arr[0], arr[1], arr[2]));
        }
    }


}