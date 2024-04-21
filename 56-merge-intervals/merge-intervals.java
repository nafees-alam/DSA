class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(!list.isEmpty() && end <= list.get(list.size() - 1).get(1)){
                continue;
            }

            for(int j = i+1; j < intervals.length; j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end, intervals[j][1]);
                } else {
                    break;
                }
            }
            ArrayList<Integer> ll = new ArrayList<>();
            ll.add(start);
            ll.add(end);
            list.add(new ArrayList<>(ll));
        }

        int[][] ans = new int[list.size()][2];

        for(int i = 0; i < list.size(); i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}