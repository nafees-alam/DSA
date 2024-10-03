class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int tempSum = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            tempSum += nums[i];
            int rem = ((tempSum%k)+k)%k;
            if(map.containsKey(rem)){
                cnt += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return cnt;
    }
}