class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int m = intervals[0].length;
        Arrays.sort(intervals, Comparator.comparingDouble(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});
        int k = 0;

        for(int i = 1; i < n; i++){
            if(list.get(k)[1] < intervals[i][0]){
                k++;
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            } else{
                int[] temp = list.get(k);
                temp[1] = Math.max(intervals[i][1], temp[1]);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}