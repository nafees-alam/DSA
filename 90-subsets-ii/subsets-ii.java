class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        HashSet<List<Integer>> tempSet = new HashSet<>();
        Arrays.sort(nums);
        

        helper(tempSet, new ArrayList<>(), nums, 0);

        List<List<Integer>> ans = new ArrayList<>(tempSet);
        return ans;
    }

    public void helper(HashSet<List<Integer>> ans,List<Integer> temp, int[] nums, int idx){
        if(idx == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        //yes
        temp.add(nums[idx]);
        helper(ans,temp, nums, idx+1);

        //No
        temp.remove(temp.size()-1);
        helper(ans,temp, nums, idx+1);
    }
}