class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> posList = new ArrayList<>();
        ArrayList<Integer> negList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(nums[i] < 0){
                negList.add(nums[i]);
            } else{
                posList.add(nums[i]);
            }
        }

        for(int i = 0; i < posList.size()*2; i += 2){
            nums[i] = posList.get(i/2);
            nums[i+1] = negList.get(i/2);
        }

        return nums;
    }
}