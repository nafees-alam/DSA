class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] preXor = new int[n];
        int[] ans = new int[n];
        int maxLim = (int)Math.pow(2, maximumBit)-1;
        preXor[0] = nums[0];

        for(int i = 1; i < n; i++){
            preXor[i] = preXor[i-1]^nums[i];
        }

        System.out.println(Arrays.toString(preXor));

        for(int i = n-1; i >= 0; i--){
            ans[n-i-1] = maxLim ^ preXor[i];
        }

        return ans;
    }
}