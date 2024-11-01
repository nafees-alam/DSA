class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        solve(nums, new ArrayList<>(), 0, list);
        return list;
    }

    public void solve(int[] nums, List<Integer> temp, int idx, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //take
        temp.add(nums[idx]);
        solve(nums, temp, idx+1, ans);
        //not take
        temp.remove(temp.size()-1);
        solve(nums, temp, idx+1, ans);
    }
}