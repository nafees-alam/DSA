class Solution {
    public int longestSubarray(int[] nums) {
        int maxlen = 0;
        int max = 0;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == max){
                count++;
                maxlen = Math.max(count, maxlen);
            } else{
                count = 0;
            }
        }

        return maxlen;
    }
}