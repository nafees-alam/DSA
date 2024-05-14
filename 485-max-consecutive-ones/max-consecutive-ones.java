class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int counter = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                counter++;
            } else {
                ans = Math.max(counter, ans);
                counter = 0;
            }
        }
        return Math.max(counter, ans);
    }
}