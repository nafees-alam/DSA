class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            HashSet<Integer> tempset = new HashSet<>();
            for(int j = i+1; j < nums.length; j++){
                int third = -(nums[i] + nums[j]);
                if(tempset.contains(third)){
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                    temp.sort(null);
                    set.add(temp);
                }

                tempset.add(nums[j]);
            }
        }

        for(List<Integer> temp : set){
            ans.add(temp);
        }

        return ans;
    }
}