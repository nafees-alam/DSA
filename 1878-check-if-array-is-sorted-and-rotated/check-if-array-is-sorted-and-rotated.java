class Solution {
    public boolean check(int[] nums) {
        int mountPeak = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] > nums[i+1]){
                mountPeak = i+1;
                break;
            }
        }

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[(i+mountPeak) % nums.length] > nums[(i+mountPeak+1) % nums.length]){
                return false;
            }
        }

        return true;
    }
}