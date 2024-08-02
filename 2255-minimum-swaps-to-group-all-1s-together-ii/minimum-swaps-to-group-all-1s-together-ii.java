class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int count1 = 0;
        int[] arr = new int[2*n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = nums[i%n];
        }

        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
                count1++;
            }
        }

        int r = count1;
        int zeroCount = 0;
        for(int i = 0; i < r; i++){
            if(arr[i] == 0){
                zeroCount++;
            }
        }
        int l = 0;
        int ans = zeroCount;
        while(r < 2*n){
            if(arr[r - count1] == 0) zeroCount--;
            if(arr[r] == 0) zeroCount++;

            ans = Math.min(ans, zeroCount);
            r++;
        }

        return ans;
    }
}