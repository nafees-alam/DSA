class Solution {
    public int longestSquareStreak(int[] nums) {
        int maxCnt = 1;
        HashSet<Long> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add((long)nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            int cnt = 1;
            long req = (long)Math.pow(nums[i], 2);

            while(set.contains(req)){
                cnt++;
                req = (long)Math.pow(req, 2);
            }

            maxCnt = Math.max(maxCnt, cnt);
        }

        return maxCnt == 1 ? -1 : maxCnt;
    }
}