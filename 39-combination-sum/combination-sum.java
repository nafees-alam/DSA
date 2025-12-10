class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        helper(ans, new ArrayList<>(), candidates, target, 0);

        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, int target, int idx){

        if(idx == nums.length || target < 0) return;

        if(target == 0){
            ans.add(new ArrayList<>(temp));
            return;
        }

        

        //Take
        temp.add(nums[idx]);
        helper(ans, temp, nums, target-nums[idx], idx);

        //Not Take
        temp.remove(temp.size()-1);
        helper(ans, temp, nums, target, idx+1);
    }
}