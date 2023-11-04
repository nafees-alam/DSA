class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int end = 1;
        int count = 1;
        int idx = 1;
        while(end < nums.length){
            if(nums[start] != nums[end]){
                count++;
                nums[idx] = nums[end];
                idx++;
                start = end;
            }
            end++;
        }

        return count;
    }
}