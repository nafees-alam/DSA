class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, 0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public void helper(int sum, int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> temp){
        if(idx == nums.length || sum > target){
            return;
        }
        if(sum == target ){
            ans.add(new ArrayList<>(temp));
            return;
        }

            temp.add(nums[idx]);
            helper(sum+nums[idx], idx, nums, target, ans, temp);

            if(temp.size() > 0)
            temp.remove(temp.size() -1);
            helper(sum, idx+1, nums, target, ans, temp);
    }
}