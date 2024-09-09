class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        for(int i = 0; i < nums.length; i++){
            int prod = nums[i];
            for(int j = i+1; j < nums.length; j++){
                ans = Math.max(ans, prod);
                prod *= nums[j];
            }

            ans = Math.max(ans, prod);
        }

        return ans;
    }
}