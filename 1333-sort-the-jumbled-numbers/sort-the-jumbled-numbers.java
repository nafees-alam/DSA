class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
         int[][] mappedWithIdx = new int[nums.length][2];

        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            int mapNum = curr == 0 ? mapping[0] : 0;
            mappedWithIdx[i][0] = curr;
            int mul = 1;
            while(curr > 0){
                int dig = curr%10;
                mapNum += mapping[dig] * mul;
                curr = curr/ 10;
                mul = mul * 10; 
            }
            mappedWithIdx[i][1] = mapNum;
        }

        Arrays.sort(mappedWithIdx, (n1, n2) -> (n1[1] - n2[1]));

        for(int i = 0; i < mappedWithIdx.length; i++){
            nums[i] = mappedWithIdx[i][0];
        }

        return nums;
    }
}