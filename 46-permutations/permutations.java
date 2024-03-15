class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lol = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        helper(lol, list, nums);

        return lol;
    }

    static  void helper(List<List<Integer>> lol, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            lol.add(new ArrayList<>(list));
        }

        for(int i = 0; i < nums.length; i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            helper(lol, list, nums);
            list.remove(list.size() - 1);
        }
    }
}