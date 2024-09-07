class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        for(int i = 0; i < nums.length; i++){
            int cnt = k;
            for(int j = i; j < nums.length; j++){

                if(nums[j] == 0){
                    cnt--;
                }

                if(cnt >= 0){
                    maxlen = Math.max(maxlen, j-i+1);
                } else {
                    break;
                }
            }
        }

        return maxlen;
    }
}