class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int idx = nums.length - k;
        rotateByIdx(nums, idx, nums.length - 1);
        rotateByIdx(nums, 0, idx - 1);
        rotateByIdx(nums, 0, nums.length - 1);
    }

    static void rotateByIdx(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}