class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int n = intervals.length;

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});
        int k = 0;

        for(int i = 1; i < n; i++){
            if(intervals[i][0] <= list.get(k)[1]){
                list.get(k)[1] = Math.max(list.get(k)[1], intervals[i][1]);
            } else{
                list.add(new int[]{intervals[i][0], intervals[i][1]});
                k++;
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}