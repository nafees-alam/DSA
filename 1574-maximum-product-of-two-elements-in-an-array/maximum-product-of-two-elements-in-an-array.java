class Solution {
    public int maxProduct(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        int n = nums.length;

        return (nums[n-1]-1) * (nums[n-2] -1);
    }
}