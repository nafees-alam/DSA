class Solution {
    public int missingNumber(int[] nums) {
        cycleSort(nums);
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    static void cycleSort(int[] nums){
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i && nums[i] < nums.length){
                swap(nums, nums[i], i);
            } else {
                i++;
            }
        }
    }

    static void swap(int[] nums, int fi, int si){
        int temp = nums[fi];
        nums[fi] = nums[si];
        nums[si] = temp;
    }
}