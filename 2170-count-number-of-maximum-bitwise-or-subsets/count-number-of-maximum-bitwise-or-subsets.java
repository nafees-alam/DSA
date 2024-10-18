class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int cnt = 0;
        int maxOr = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            maxOr |= nums[i];
        }

        maxSub(nums, maxOr, 0, 0);

        return ans;
    }

    int ans = 0;

    public void maxSub(int[] nums, int target, int curr, int idx){
        if(idx == nums.length){
            if(curr == target){
                ans++;
            }
            return;
        }

        //pick
        maxSub(nums, target, curr | nums[idx], idx+1);
        //notPick
        maxSub(nums, target, curr, idx+1);

    }
}