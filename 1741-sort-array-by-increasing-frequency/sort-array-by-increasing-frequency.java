class Solution {
    public int[] frequencySort(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            ans[i] = nums[i];
        }

        Arrays.sort(ans, (n1, n2) -> {
            if(map.get(n1) != map.get(n2)){
                return map.get(n1) - map.get(n2);
            } else {
                return n2 - n1;
            }
        });

        for(int i = 0; i < nums.length; i++){
            nums[i] = ans[i];
        }

        return nums;
    }
}