class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> unOcc = new PriorityQueue<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);

        int target = times[targetFriend][0];

        for(int i = 0; i < times.length; i++){
            unOcc.add(i);
        }

        Arrays.sort(times, Comparator.comparingDouble(o -> o[0]));

        for(int i = 0; i < times.length; i++){
            System.out.println(Arrays.toString(times[i]));
        }

        for(int i = 0; i < times.length; i++){

            while(!pq.isEmpty() && times[i][0] >= pq.peek().second){
                Pair p = pq.remove();
                unOcc.add(p.first);
            }

            if(target == times[i][0]){
                return unOcc.peek();
            }

            pq.add(new Pair(unOcc.remove(), times[i][1]));
        }

        return -1;
    }
}

class Pair{
    int first;
    int second;

    Pair(int i, int j){
        first = i;
        second = j;
    }
}
