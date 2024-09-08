class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        int l = 0;
        int r = 0;
        int countZeros = 0;
        int n = nums.length;

        while(r < n){
            if(nums[r] == 0){
                countZeros++;
            }

            while(countZeros > k){
                if(nums[l] == 0){
                    countZeros--;
                }
                l++;
            }

            maxlen = Math.max(maxlen, r-l+1);
            r++;
        }

        return maxlen;
    }
}