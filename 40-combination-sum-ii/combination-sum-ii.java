class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, 0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    public void helper(int sum, int idx, int[] nums, int target, List<List<Integer>> ans, List<Integer> temp) {
        if(sum == target){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = idx; i < nums.length; i++){
            if(sum > target){
                break;
            }
            if (i > idx && nums[i] == nums[i - 1]) {
                continue; // Skip duplicates
            }
            temp.add(nums[i]);
            helper(sum+nums[i], i+1, nums, target, ans, temp);
            temp.remove(temp.size() -1);
        }
        
    }
}