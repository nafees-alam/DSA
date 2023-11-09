class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1){
            return;
        }
        int nonZeroIdx = 0;
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] != 0){
                nums[nonZeroIdx] = nums[i];
                nonZeroIdx++;
            }
        }

        while(nonZeroIdx < nums.length){
            nums[nonZeroIdx] = 0;
            nonZeroIdx++;
        }
    }
}