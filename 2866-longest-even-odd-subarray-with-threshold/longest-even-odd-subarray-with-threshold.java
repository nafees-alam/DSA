class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
           int count = 0;
           if(nums[i] % 2 == 0 && nums[i] <= threshold){
            count++;
            for(int j = i+1; j < nums.length; j++){
                if(nums[j-1] % 2 != nums[j] % 2 && nums[j] <= threshold){
                    count++;
                } else {
                    break;
                }
            }
           }

           ans = Math.max(ans, count);
        }

        return ans;
    }
}