class Solution {
    public int minGroups(int[][] intervals) {
        
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        for(int i = 0; i < intervals.length; i++){
            System.out.print("(" + intervals[i][0] +","+ intervals[i][1]+")"+" ");
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(intervals[0][1]);
        for(int i = 1; i < intervals.length; i++){
            if(pq.peek() >= intervals[i][0]){
                pq.add(intervals[i][1]);
            } else{
                pq.remove();
                pq.add(intervals[i][1]);
            }
        }

        return pq.size();
    }
}