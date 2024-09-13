class Solution {
    public int findGCD(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        int ans = 0;
        int div = min;
        while(div > 0){
            if(min % div == 0 && max % div == 0){
                return div;
            }
            div--;
        }

        return 1;
    }
}