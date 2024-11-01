class Solution {
    public int findMin(int[] nums) {
        int pivot = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > nums[i]){
                pivot = i;
                break;
            }
        }

        return Math.min(nums[0], nums[pivot]);
    }
}