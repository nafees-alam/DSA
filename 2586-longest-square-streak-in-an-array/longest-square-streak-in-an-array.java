class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxCnt = 1;
        TreeSet<Long> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add((long)nums[i]);
        }
        for(long val : set){
            int cnt = 1;
            long num = val;

            while(set.contains(num * num)){
                cnt++;
                num = num * num;
            }

            maxCnt = Math.max(maxCnt, cnt);
        }

        return maxCnt == 1 ? -1 : maxCnt;
    }
}