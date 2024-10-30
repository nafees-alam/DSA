class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            Set<Integer> set2 = new HashSet<>();
            for(int j = i+1; j < nums.length; j++){
                if(set2.contains(-(nums[i]+nums[j]))){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(-(nums[i] + nums[j]));
                    Collections.sort(temp);
                    set.add(temp);
                }
                set2.add(nums[j]);
            }
        }

        for(List<Integer> val : set){
            list.add(val);
        }

        return list;
    }
}