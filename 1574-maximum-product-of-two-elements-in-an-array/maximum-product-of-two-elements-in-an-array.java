class Solution {
    public int maxProduct(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(a < nums[i]){
                int temp = a;
                a = nums[i];
                // if(b < temp){
                //     b = temp;
                // }
                b = temp;
            } else if(b < nums[i]){
                b = nums[i];
            }
        }

        return (a-1)*(b-1);
    }
}